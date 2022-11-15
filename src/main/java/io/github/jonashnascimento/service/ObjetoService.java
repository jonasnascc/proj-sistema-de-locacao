package io.github.jonashnascimento.service;

import io.github.jonashnascimento.domain.entity.Objeto;
import io.github.jonashnascimento.rest.dto.ObjetoDTO;

public interface ObjetoService {
    Objeto save(ObjetoDTO dto);
}
