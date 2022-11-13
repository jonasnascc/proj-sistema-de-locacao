package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetoRepository extends JpaRepository<Objeto, Integer> {
}
