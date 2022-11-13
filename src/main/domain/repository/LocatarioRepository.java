package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Locatario;
import io.github.jonashnascimento.domain.entity.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocatarioRepository extends JpaRepository<Locatario, Integer> {
    @Query("select l from Locador l left join fetch l.objetosAlugados o where l.id = :id and o.locadoFlag = true")
    List<Objeto> findLocatarioFetchObjetosPropriosLocados(@Param("id") Integer id);

    @Query("select l from Locador l left join fetch l.objetosAlugados o where l.id = :id")
    List<Objeto> findLocatarioFetchObjetosProprios(@Param("id") Integer id);
}
