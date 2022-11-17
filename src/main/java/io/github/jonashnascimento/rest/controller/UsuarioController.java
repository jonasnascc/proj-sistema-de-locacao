package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.domain.entity.Locador;
import io.github.jonashnascimento.domain.entity.Locatario;
import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.domain.repository.UsuarioRepository;
import io.github.jonashnascimento.rest.dto.InfoUsuarioDTO;
import io.github.jonashnascimento.rest.dto.UsuarioDTO;
import io.github.jonashnascimento.service.UsuarioService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
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
public class UsuarioController {
    private final UsuarioRepository usuarios;

    private final UsuarioService service;

    public UsuarioController(UsuarioRepository usuarios, UsuarioService service){
        this.usuarios = usuarios;
        this.service = service;
    }

    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable("id") Integer id){
        return usuarios.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody UsuarioDTO dto){
        return service.save(dto).getId();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        usuarios.findById(id).map(usuario -> {
            usuarios.delete(usuario);
            return usuario;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }


    @GetMapping
    public List<InfoUsuarioDTO> find(Locador filtroLocador, Locatario filtroLocatario){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Usuario> exampleLocador = Example.of(filtroLocador, matcher);
        Example<Usuario> exampleLocatario = Example.of(filtroLocatario, matcher);


        List<Usuario> all = usuarios.findAll(exampleLocador);
        all.addAll(usuarios.findAll(exampleLocatario));

        return converter(all);
    }

    /*@GetMapping
    public List<InfoUsuarioDTO> find(Usuario filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Usuario> example = Example.of(filtro, matcher);

        return converter(usuarios.findAll(example));
    }*/

    private List<InfoUsuarioDTO> converter(List<Usuario> users){
        if(CollectionUtils.isEmpty(users)) return Collections.emptyList();

        return users.stream().map(
                user -> InfoUsuarioDTO.builder()
                        .codigo(user.getId())
                        .nome(user.getNome())
                        .cpf(user.getCpf())
                        .telefone(user.getTelefone())
                        .tipoUsuario(user.getClass().getSimpleName().toLowerCase(Locale.ROOT))
                        .build()
                ).collect(Collectors.toList());
    }
}
