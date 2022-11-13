package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
}
