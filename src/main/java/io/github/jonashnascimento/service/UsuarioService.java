package io.github.jonashnascimento.service;

import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.rest.dto.UsuarioDTO;

public interface UsuarioService {
    Usuario save(UsuarioDTO dto);
}
