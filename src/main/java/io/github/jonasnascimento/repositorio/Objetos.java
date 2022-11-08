package io.github.jonasnascimento.repositorio;

import io.github.jonasnascimento.model.Objeto;
import io.github.jonasnascimento.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Objetos extends JpaRepository<Objeto,Integer> {


    List<Objeto> findByTipo(Tipo tipo);

    /*@Query(value = "select o from Objeto o where o.tipo.nome =: tipo")
    List<Objeto> findByNomeTipo(String tipo);*/



    // @Query(value = "select c from Objeto c where c.descricao like :descricao")
    // List<Objeto> encontrarPorDescricao(@Param("descricao") String descricao);

}
