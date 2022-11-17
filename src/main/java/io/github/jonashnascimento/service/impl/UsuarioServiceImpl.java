package io.github.jonashnascimento.service.impl;

import io.github.jonashnascimento.domain.entity.Locador;
import io.github.jonashnascimento.domain.entity.Locatario;
import io.github.jonashnascimento.domain.entity.Usuario;
import io.github.jonashnascimento.domain.repository.LocadorRepository;
import io.github.jonashnascimento.domain.repository.UsuarioRepository;
import io.github.jonashnascimento.exception.RegraNegocioException;
import io.github.jonashnascimento.rest.dto.UsuarioDTO;
import io.github.jonashnascimento.service.UsuarioService;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public Usuario save(UsuarioDTO dto) {
        Usuario usuario = validaUsuario(dto.getTipoUsuario());

        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setTelefone(dto.getTelefone());

        repository.save(usuario);

        return usuario;
    }

    private Usuario validaUsuario(String tipoUsuario){
        Usuario usuario = switch (tipoUsuario) {
            case "locador" -> new Locador();
            case "locatario" -> new Locatario();
            default -> null;
        };

        if(usuario == null) {
            throw new RegraNegocioException("Tipo de usuário inválido.");
        }

        return usuario;
    }

}
