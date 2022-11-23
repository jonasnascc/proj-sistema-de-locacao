package io.github.jonashnascimento.service.impl;

import io.github.jonashnascimento.domain.entity.*;
import io.github.jonashnascimento.domain.enums.StatusObjeto;
import io.github.jonashnascimento.domain.enums.StatusPagamento;
import io.github.jonashnascimento.domain.repository.*;
import io.github.jonashnascimento.exception.RegraNegocioException;
import io.github.jonashnascimento.rest.dto.ContratoDTO;
import io.github.jonashnascimento.rest.dto.PagamentoDTO;
import io.github.jonashnascimento.rest.dto.LocacaoDTO;
import io.github.jonashnascimento.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocacaoServiceImpl implements LocacaoService {

    private final LocacaoRepository repository;

    private final UsuarioRepository usuarioRepository;
    private final ContratoRepository contratoRepository;
    private final ObjetoRepository objetoRepository;
    private final FaturaRepository faturaRepository;

    @Override
    @Transactional
    public Locacao salvar(LocacaoDTO dto) {
        Locacao locacao = new Locacao();

        Usuario locador = usuarioRepository.findById(dto.getLocador()).orElseThrow(() -> new RegraNegocioException("Código de locador inválido"));
        Usuario locatario = usuarioRepository.findById(dto.getLocatario()).orElseThrow(() -> new RegraNegocioException("Código de locatario inválido"));

        locacao.setLocador(locador);
        locacao.setLocatario(locatario);

        Objeto objeto = objetoRepository.findById(dto.getObjeto()).orElseThrow(() -> new RegraNegocioException("Código de objeto não encontrado."));
        objeto.setStatus(StatusObjeto.LOCADO);
        locacao.setObjeto(objeto);
        objetoRepository.save(objeto);

        Contrato contrato = converterContrato(locacao, dto.getContrato());
        repository.save(locacao);
        contratoRepository.save(contrato);

        locacao.setContrato(contrato);
        return locacao;
    }

    @Override
    public Optional<Locacao> obterLocacaoCompleta(Integer id) {
        return repository.findByIdFetchContratoFetchObjeto(id);
    }

    @Override
    public Locacao update(LocacaoDTO dto) {
        return null;
    }

    @Override
    public Locacao delete(LocacaoDTO dto) {
        return null;
    }

    private Contrato converterContrato(Locacao locacao, ContratoDTO dto){
        Contrato contrato = new Contrato();

        contrato.setLocacao(locacao);
        contrato.setNumPagamentos(dto.getNumPagamentos());
        contrato.setValorPagamentos(dto.getValorPagamentos());
        contrato.setIntervaloDias(dto.getIntervaloDias());

        List<Pagamento> faturas = converterFatura(contrato, dto.getPagamentos());

        faturaRepository.saveAll(faturas);
        contrato.setPagamentos(faturas);
        return contrato;
    }

    private List<Pagamento> converterFatura(Contrato contrato, List<PagamentoDTO> items){
        if(items == null) return Collections.emptyList();

        if(items.isEmpty())
            throw new RegraNegocioException("Não é possível realizar uma Locação.");

        return items.stream().map(dto -> {
            Pagamento pagamento = new Pagamento();
            pagamento.setContrato(contrato);
            pagamento.setValor(contrato.getValorPagamentos());
            pagamento.setParcelaReferencia(dto.getParcelaReferencia());
            pagamento.setData(converterData(dto.getData()));
            pagamento.setStatus(converterStatusPagamento(dto.getStatus()));
            return pagamento;
        }).collect(Collectors.toList());
    }

    private Date converterData(String data){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException e){
            throw new RegraNegocioException("Formato de data inválido.");
        }
    }

    private StatusPagamento converterStatusPagamento(String status){
        try {
            return StatusPagamento.valueOf(status);
        } catch (IllegalArgumentException e){
            throw new RegraNegocioException("Status de pagamento inválido.");
        }
    }



}
