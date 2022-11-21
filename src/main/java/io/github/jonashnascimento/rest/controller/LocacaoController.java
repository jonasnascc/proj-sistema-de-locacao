package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.domain.entity.Locacao;
import io.github.jonashnascimento.domain.repository.LocacaoRepository;
import io.github.jonashnascimento.rest.dto.InfoLocacaoDTO;
import io.github.jonashnascimento.rest.dto.LocacaoDTO;
import io.github.jonashnascimento.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/locacoes")
@RequiredArgsConstructor
public class LocacaoController {
    private final LocacaoService service;
    private final LocacaoRepository locacoes;

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody @Valid LocacaoDTO dto){
        Locacao locacao = service.salvar(dto);
        return locacao.getId();
    }

    @PutMapping
    @ResponseStatus(NO_CONTENT)
    public Integer update(@RequestBody LocacaoDTO dto){
        Locacao locacao = service.update(dto);
        return locacao.getId();
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public Integer delete(@RequestBody LocacaoDTO dto){
        Locacao locacao = service.delete(dto);
        return locacao.getId();
    }

    @GetMapping("{id}")
    public InfoLocacaoDTO getById(@PathVariable Integer id){
        return service.obterLocacaoCompleta(id).map(this::converter).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Locacao não encontrada."));
    }

    @GetMapping
    public List<Locacao> find(Locacao filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Locacao> example = Example.of(filtro, matcher);

        return locacoes.findAll(example);
    }

    private InfoLocacaoDTO converter(Locacao locacao){
        return InfoLocacaoDTO.builder()
                .codigo(locacao.getId())
                .nomeLocador(locacao.getLocador().getNome())
                .cpfLocador(locacao.getLocador().getCpf())
                .nomeLocatario(locacao.getLocatario().getNome())
                .cpfLocatario(locacao.getLocatario().getCpf())
                .valorLocacao(locacao.getContrato().getValorPagamentos())
                .numeroParcelas(locacao.getContrato().getNumPagamentos())
                .intervaloDias(locacao.getContrato().getIntervaloDias())
                .nomeObjeto(locacao.getObjeto().getDescricao())
                .tipoObjeto(locacao.getObjeto().getTipo().getNome())
                .caracteristicasObjeto(locacao.getObjeto().getCaracteristicas())
                .build();
    }
}
