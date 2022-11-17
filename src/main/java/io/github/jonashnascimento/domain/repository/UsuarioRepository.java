package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findUsuarioByCpf(String cpf);

    @Query("select u from Usuario u left join fetch u.objetosProprios where u.id = :id")
    Optional<Usuario> findUsuarioFetchObjetosProprios(@Param("id") Integer id);

}
