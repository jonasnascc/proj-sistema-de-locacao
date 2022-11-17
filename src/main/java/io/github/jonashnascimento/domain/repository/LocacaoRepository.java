package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface LocacaoRepository extends JpaRepository<Locacao, Integer> {

    @Query("select l from Locacao l left join l.contrato left join l.objeto where l.id = :id")
    Optional<Locacao> findByIdFetchContratoFetchObjeto(@Param("id") Integer locacaoId);
}
