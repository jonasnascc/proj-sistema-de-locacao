package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Integer> {
}
