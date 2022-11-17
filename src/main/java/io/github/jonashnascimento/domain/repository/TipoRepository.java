package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.TipoObjeto;
import io.github.jonashnascimento.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TipoRepository extends JpaRepository<TipoObjeto, Integer> {
    List<TipoObjeto> findTipoByCriador(Usuario usuario);

    Optional<TipoObjeto> searchByNome(String nome);

    @Query(value = "select t from TipoObjeto t left join fetch t.objetos o where t.id =: id")
    Optional<TipoObjeto> findTipoFetchObjetos(@Param("id") Integer id);
}
