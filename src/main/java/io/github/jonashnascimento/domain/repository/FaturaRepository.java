package io.github.jonashnascimento.domain.repository;


import io.github.jonashnascimento.domain.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaRepository extends JpaRepository<Pagamento, Integer> {
}
