package io.github.jonashnascimento.service;

import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.rest.dto.UsuarioDTO;

import java.util.Optional;

public interface UsuarioService {
    Usuario save(UsuarioDTO dto);

    void update(Integer id, Usuario usuario);

    void delete(Integer id);

    Optional<Usuario> getById(Integer id);
}
