package io.github.jonashnascimento.service.impl;

import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.domain.repository.UsuarioRepository;
import io.github.jonashnascimento.rest.dto.UsuarioDTO;
import io.github.jonashnascimento.service.UsuarioService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public Usuario save(UsuarioDTO dto) {
        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setTelefone(dto.getTelefone());

        repository.save(usuario);

        return usuario;
    }

    @Override
    public void update(Integer id, Usuario usuario) {
        repository.findById(id).map(locadorExistente -> {
            usuario.setId(locadorExistente.getId());
            repository.save(usuario);
            return usuario;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @Override
    public void delete(Integer id) {
        repository.findById(id).map(usuario -> {
            repository.delete(usuario);
            return usuario;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @Override
    public Optional<Usuario> getById(Integer id) {
        return repository.findById(id);
    }


}
