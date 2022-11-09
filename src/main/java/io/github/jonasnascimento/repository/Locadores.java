package io.github.jonasnascimento.repositorio;

import io.github.jonasnascimento.model.Locador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Locadores extends JpaRepository<Locador, Integer> {

    @Query(value = "select l from Locador l left join fetch l.objetos_alugados where l.id = :id")
    Locador findLocadorFetchObjetos( @Param("id") Integer id );


}
