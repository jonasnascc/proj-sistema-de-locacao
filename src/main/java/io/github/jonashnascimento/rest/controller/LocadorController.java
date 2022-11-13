package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.domain.entity.Locador;
import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.domain.repository.LocadorRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios/locadores")
public class LocadorController {
    private LocadorRepository locadores;

    public LocadorController(LocadorRepository locadores){
        this.locadores = locadores;
    }

    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable("id") Integer id){
        return locadores.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Locador save(@RequestBody  Locador locador){
        return locadores.save(locador);

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        locadores.findById(id).map(locador -> {
            locadores.delete(locador);
            return locador;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Locador locador){
        locadores.findById(id).map(locadorExistente -> {
            locadorExistente.setId(locadorExistente.getId());
            locadores.save(locadorExistente);
            return locadorExistente;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @GetMapping
    public List<Locador> find(Locador filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);


        return locadores.findAll(example);
    }
}
