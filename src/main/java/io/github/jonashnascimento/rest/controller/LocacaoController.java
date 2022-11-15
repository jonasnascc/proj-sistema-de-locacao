package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.domain.entity.Locacao;
import io.github.jonashnascimento.rest.dto.LocacaoDTO;
import io.github.jonashnascimento.service.LocacaoService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

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
}
