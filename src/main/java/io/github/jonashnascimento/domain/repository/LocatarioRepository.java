package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Locador;
import io.github.jonashnascimento.domain.entity.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
public interface LocatarioRepository extends JpaRepository<Locatario, Integer> {
    Locador findLocatarioByCpf(String cpf);

    @Query("select l from Locatario l left join l.objetosProprios where l.id = :id")
    Optional<Locatario> findLocatarioFetchObjetos(@Param("id") Integer id);

}
