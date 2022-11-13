package io.github.jonashnascimento.domain.repository;


import io.github.jonashnascimento.domain.entity.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaRepository extends JpaRepository<Fatura, Integer> {
}
