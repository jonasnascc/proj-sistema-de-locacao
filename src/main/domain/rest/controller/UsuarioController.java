package io.github.jonashnascimento.domain.rest.controller;

import io.github.jonashnascimento.domain.entity.Locador;
import io.github.jonashnascimento.domain.entity.Locatario;
import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.domain.repository.UsuarioRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarios;

    public UsuarioController(UsuarioRepository usuarios){
        this.usuarios = usuarios;
    }

    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable("id") Integer id){
        return usuarios.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
    }

    @PostMapping("/locadores")
    @ResponseStatus(HttpStatus.CREATED)
    public Locador save(@RequestBody Locador locador){
        return usuarios.save(locador);

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        usuarios.findById(id).map(usuario -> {
            usuarios.delete(usuario);
            return usuario;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @PutMapping("locadores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Locador usuario){
        usuarios.findById(id).map(usuarioExistente -> {
            usuario.setId(usuarioExistente.getId());
            usuarios.save(usuario);
            return usuarioExistente;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @GetMapping
    public List<Usuario> find(Locador filtroLocador, Locatario filtroLocatario){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example exampleLocador = Example.of(filtroLocador, matcher);
        Example exampleLocatario = Example.of(filtroLocatario, matcher);


        List<Usuario> all = usuarios.findAll(exampleLocador);
        all.addAll(usuarios.findAll(exampleLocatario));

        return all;
    }
}
