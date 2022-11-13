package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.domain.entity.Locador;
import io.github.jonashnascimento.domain.entity.Locatario;
import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.domain.repository.LocatarioRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios/locatarios")
public class LocatarioController {
    private LocatarioRepository locatarios;

    public LocatarioController(LocatarioRepository locatarios){
        this.locatarios = locatarios;
    }

    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable("id") Integer id){
        return locatarios.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Locatario save(@RequestBody Locatario locatario){
        return locatarios.save(locatario);

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        locatarios.findById(id).map(usuario -> {
            locatarios.delete(usuario);
            return usuario;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Locatario locatario){
        locatarios.findById(id).map(locatarioExistente -> {
            locatario.setId(locatarioExistente.getId());
            locatarios.save(locatario);
            return locatarioExistente;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @GetMapping
    public List<Locatario> find(Locatario filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);


        return locatarios.findAll(example);
    }
}
