package io.github.jonashnascimento.rest.controller;

import io.github.jonashnascimento.domain.entity.Objeto;
import io.github.jonashnascimento.domain.enums.StatusObjeto;
import io.github.jonashnascimento.domain.repository.ObjetoRepository;
import io.github.jonashnascimento.rest.dto.AtualizarObjetoStatusDTO;
import io.github.jonashnascimento.rest.dto.info.InfoObjetoDTO;
import io.github.jonashnascimento.rest.dto.ObjetoDTO;
import io.github.jonashnascimento.service.ObjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/objetos")
@RequiredArgsConstructor
public class ObjetoController {
    private final ObjetoService service;
    private final ObjetoRepository objetos;

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody @Valid ObjetoDTO dto){
        Objeto objeto = service.save(dto);
        return objeto.getId();
    }

    @PatchMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateStatus(@PathVariable Integer id, @RequestBody AtualizarObjetoStatusDTO dto){
        service.atualizaStatus(id, StatusObjeto.valueOf(dto.getNovoStatus().toUpperCase()));
    }



    @GetMapping
    public List<InfoObjetoDTO> find(Objeto filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Objeto> example = Example.of(filtro, matcher);

        return converter(objetos.findAll(example));
    }

    private List<InfoObjetoDTO> converter(List<Objeto> objetos){
        return objetos.stream().map(o -> InfoObjetoDTO.builder()
                .codigo(o.getId())
                .descricao(o.getDescricao())
                .caracteristicas(o.getCaracteristicas())
                .status(o.getStatus().name())
                .tipo(o.getTipo().getNome())
                .dono(o.getDono().getNome())
                .donoId(o.getDono().getId())
                .build()).collect(Collectors.toList());

    }
}
