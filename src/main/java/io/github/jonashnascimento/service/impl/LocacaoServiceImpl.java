package io.github.jonashnascimento.service.impl;

import io.github.jonashnascimento.domain.entity.*;
import io.github.jonashnascimento.domain.repository.*;
import io.github.jonashnascimento.exception.RegraNegocioException;
import io.github.jonashnascimento.rest.dto.ContratoDTO;
import io.github.jonashnascimento.rest.dto.FaturaDTO;
import io.github.jonashnascimento.rest.dto.LocacaoDTO;
import io.github.jonashnascimento.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocacaoServiceImpl implements LocacaoService {

    private final LocacaoRepository repository;
    private final ContratoRepository contratoRepository;
    private final ObjetoRepository objetoRepository;
    private final LocadorRepository locadorRepository;
    private final LocatarioRepository locatarioRepository;
    private final FaturaRepository faturaRepository;

    @Override
    @Transactional
    public Locacao salvar(LocacaoDTO dto) {
        Locacao locacao = new Locacao();

        Locador locador = locadorRepository.findById(dto.getLocador()).orElseThrow(() -> new RegraNegocioException("Código de locador inválido"));
        Locatario locatario = locatarioRepository.findById(dto.getLocatario()).orElseThrow(() -> new RegraNegocioException("Código de locador inválido"));

        locacao.setLocador(locador);
        locacao.setLocatario(locatario);
        locacao.setObjeto(objetoRepository.findById(dto.getObjeto()).orElseThrow(() -> new RegraNegocioException("Código de objeto não encontrado.")));

        Contrato contrato = converterContrato(locacao, dto.getContrato());
        repository.save(locacao);
        contratoRepository.save(contrato);

        locacao.setContrato(contrato);
        return locacao;
    }

    private Contrato converterContrato(Locacao locacao, ContratoDTO dto){
        Contrato contrato = new Contrato();

        contrato.setLocacao(locacao);
        contrato.setN_faturas(dto.getN_faturas());
        contrato.setValorFaturas(dto.getValorFaturas());
        contrato.setIntervaloDias(dto.getIntervaloDias());

        List<Fatura> faturas = converterFatura(contrato, dto.getFaturas());

        faturaRepository.saveAll(faturas);
        contrato.setFaturas(faturas);
        return contrato;
    }

    private List<Fatura> converterFatura(Contrato contrato, List<FaturaDTO> items){
        if(items.isEmpty())
            throw new RegraNegocioException("Não é possível realizar uma Locação.");

        return items.stream().map(dto -> {
            Fatura fatura = new Fatura();
            fatura.setContrato(contrato);
            fatura.setValor(contrato.getValorFaturas());
            fatura.setParcelaReferencia(dto.getParcelaReferencia());
            fatura.setPagamentoEfetuado(dto.isPagamentoEfetuado());
            return fatura;
        }).collect(Collectors.toList());
    }



}
