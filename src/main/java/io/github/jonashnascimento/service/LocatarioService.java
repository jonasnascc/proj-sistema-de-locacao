package io.github.jonashnascimento.service;

import io.github.jonashnascimento.domain.entity.Locatario;
import io.github.jonashnascimento.domain.entity.Objeto;

import java.util.Optional;

public interface LocatarioService {
    Optional<Locatario> obterLocatarioCompleto(Integer id);
}
