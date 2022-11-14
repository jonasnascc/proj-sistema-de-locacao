package io.github.jonashnascimento.rest.controller;


import io.github.jonashnascimento.service.ObjetoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/objetos")
public class ObjetoController {
    private ObjetoService service;

    public ObjetoController(ObjetoService service){
        this.service = service;
    }
}
