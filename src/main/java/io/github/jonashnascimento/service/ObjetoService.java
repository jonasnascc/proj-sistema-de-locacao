package io.github.jonashnascimento.service;

import io.github.jonashnascimento.domain.entity.Objeto;
import io.github.jonashnascimento.domain.enums.StatusObjeto;
import io.github.jonashnascimento.rest.dto.ObjetoDTO;

import java.util.Optional;

public interface ObjetoService {
    Objeto save(ObjetoDTO dto);

    void update(Integer id, Objeto objeto);

    void delete(Integer id);

    Optional<Objeto> getById(Integer id);

    void atualizaStatus(Integer id, StatusObjeto status);
}
