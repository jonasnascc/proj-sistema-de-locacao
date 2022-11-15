package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Locador;
import io.github.jonashnascimento.domain.entity.Locatario;
import io.github.jonashnascimento.domain.entity.Objeto;
import io.github.jonashnascimento.domain.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {
    List<Tipo> findTipoByCriador(Locatario locatario);

    @Query(value = "select t from Tipo t left join fetch t.objetos o where t.id =: id")
    Tipo findTipoFetchObjetos(@Param("id") Integer id);

    Tipo searchByNome(String nome);



}
