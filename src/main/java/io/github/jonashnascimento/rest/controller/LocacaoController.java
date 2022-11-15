package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.service.LocacaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/locacoes")
public class LocacaoController {
    private LocacaoService service;

    public LocacaoController(LocacaoService service) {
        this.service = service;
    }
}
