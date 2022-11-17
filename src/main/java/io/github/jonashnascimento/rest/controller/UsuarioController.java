package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.domain.repository.UsuarioRepository;
import io.github.jonashnascimento.rest.dto.UsuarioDTO;
import io.github.jonashnascimento.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioRepository usuarios;

    private final UsuarioService service;

    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable("id") Integer id){
        return service.getById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário não encontrado"));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody UsuarioDTO dto){
        return service.save(dto).getId();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Usuario usuario){
        service.update(id, usuario);
    }

    @GetMapping
    public List<Usuario> find(Usuario filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Usuario> example = Example.of(filtro, matcher);


        return usuarios.findAll(example);
    }


}
