package io.github.jonashnascimento.service;

import io.github.jonashnascimento.domain.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Usuario save(Usuario usuario);

    void update(Integer id, Usuario usuario);

    void delete(Integer id);

    Optional<Usuario> getById(Integer id);
}
