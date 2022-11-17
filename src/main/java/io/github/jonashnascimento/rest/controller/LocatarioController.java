package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.domain.entity.Locador;
import io.github.jonashnascimento.domain.entity.Locatario;
import io.github.jonashnascimento.domain.entity.Objeto;
import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.domain.repository.LocatarioRepository;
import io.github.jonashnascimento.rest.dto.InfoLocacaoDTO;
import io.github.jonashnascimento.rest.dto.InfoLocatarioDTO;
import io.github.jonashnascimento.rest.dto.InfoObjetoDTO;
import io.github.jonashnascimento.rest.dto.ObjetoDTO;
import io.github.jonashnascimento.service.LocatarioService;
import io.github.jonashnascimento.service.impl.LocatarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/api/usuarios/locatarios")
@RequiredArgsConstructor
public class LocatarioController {
    private final LocatarioRepository locatarios;

    private final LocatarioService service;

   /* @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable("id") Integer id){
        return locatarios.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
    }*/

    @PostMapping
    @ResponseStatus(CREATED)
    public Locatario save(@RequestBody Locatario locatario){
        return locatarios.save(locatario);

    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id){
        locatarios.findById(id).map(usuario -> {
            locatarios.delete(usuario);
            return usuario;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
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

    @GetMapping("{id}")
    public InfoLocatarioDTO getById(@PathVariable Integer id){
        return service.obterLocatarioCompleto(id).map(this::converter).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Locatario não encontrado."));
    }

    private InfoLocatarioDTO converter(Locatario locatario){
        return InfoLocatarioDTO.builder()
                .codigo(locatario.getId())
                .nome(locatario.getNome())
                .cpf(locatario.getCpf())
                .telefone(locatario.getTelefone())
                .objetosProprios(converter(locatario.getObjetosProprios()))
                .build();
    }

    private List<InfoObjetoDTO> converter(List<Objeto> objetos){
        return objetos.stream().map(objeto ->
            InfoObjetoDTO.builder()
                    .nome(objeto.getNome())
                    .codigo(objeto.getId())
                    .caracteristicas(objeto.getCaracteristicas())
                    .tipo(objeto.getTipo().getNome())
                    .status(objeto.getStatus().name())
                    .build()
        ).collect(Collectors.toList());
    }
}
