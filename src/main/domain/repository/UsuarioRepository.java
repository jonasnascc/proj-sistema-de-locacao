package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
