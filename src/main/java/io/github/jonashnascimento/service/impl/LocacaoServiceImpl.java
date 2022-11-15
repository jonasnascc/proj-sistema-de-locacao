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

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocacaoServiceImpl implements LocacaoService {

    private final LocacaoRepository repository;
    private final ContratoRepository contratoRepository;
    private final ObjetoRepository objetoRepository;
    private final LocadorRepository locadorRepository;
    private final LocatarioRepository locatarioRepository;

    @Override
    public Integer salvar(LocacaoDTO dto) {
        Locacao locacao = new Locacao();

        Locador locador = locadorRepository.findById(dto.getLocador()).orElseThrow(() -> new RegraNegocioException("Código de locador inválido"));
        Locatario locatario = locatarioRepository.findById(dto.getLocatario()).orElseThrow(() -> new RegraNegocioException("Código de locador inválido"));

        locacao.setLocador(locador);
        locacao.setLocatario(locatario);
        locacao.setContrato(converterContrato(locacao, dto.getContrato()));
        return null;
    }

    private Contrato converterContrato(Locacao locacao, ContratoDTO dto){
        Contrato contrato = new Contrato();

        contrato.setLocacao(locacao);
        contrato.setN_faturas(dto.getN_faturas());
        contrato.setValorFaturas(dto.getValorFaturas());
        contrato.setIntervaloDias(dto.getIntervaloDias());

        contrato.setFaturas(converterFatura(contrato, dto.getFaturas()));

        return contrato;
    }

    private List<Fatura> converterFatura(Contrato contrato, List<FaturaDTO> dto){
        return null;
    }



}
