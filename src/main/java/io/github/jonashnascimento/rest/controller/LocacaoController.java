package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.domain.entity.Locacao;
import io.github.jonashnascimento.rest.dto.InfoLocacaoDTO;
import io.github.jonashnascimento.rest.dto.LocacaoDTO;
import io.github.jonashnascimento.service.LocacaoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/locacoes")
public class LocacaoController {
    private LocacaoService service;

    public LocacaoController(LocacaoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody LocacaoDTO dto){
        Locacao locacao = service.salvar(dto);
        return locacao.getId();
    }

    @GetMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public InfoLocacaoDTO getById(@PathVariable Integer id){
        return service.obterLocacaoCompleta(id).map(this::converter).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Locacao não encontrada."));
    }

    private InfoLocacaoDTO converter(Locacao locacao){
        return InfoLocacaoDTO.builder()
                .codigo(locacao.getId())
                .nomeLocador(locacao.getLocador().getNome())
                .cpfLocador(locacao.getLocador().getCpf())
                .nomeLocatario(locacao.getLocatario().getNome())
                .cpfLocatario(locacao.getLocatario().getCpf())
                .valorLocacao(locacao.getContrato().getValorFaturas())
                .numeroParcelas(locacao.getContrato().getN_faturas())
                .intervaloDias(locacao.getContrato().getIntervaloDias())
                .nomeObjeto(locacao.getObjeto().getNome())
                .tipoObjeto(locacao.getObjeto().getTipo().getNome())
                .caracteristicasObjeto(locacao.getObjeto().getCaracteristicas())
                .build();
    }
}
