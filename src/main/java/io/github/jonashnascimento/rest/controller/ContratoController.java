package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.service.ContratoService;
import io.github.jonashnascimento.service.impl.ContratoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {
    private ContratoService service;

    public ContratoController(ContratoService service) {
        this.service = service;
    }
}
