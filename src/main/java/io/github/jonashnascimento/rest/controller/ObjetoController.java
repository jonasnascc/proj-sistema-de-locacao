package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.domain.entity.Objeto;
import io.github.jonashnascimento.rest.dto.ObjetoDTO;
import io.github.jonashnascimento.service.ObjetoService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/objetos")
public class ObjetoController {
    private ObjetoService service;

    public ObjetoController(ObjetoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody ObjetoDTO dto){
        Objeto objeto = service.save(dto);
        return objeto.getId();
    }
}
