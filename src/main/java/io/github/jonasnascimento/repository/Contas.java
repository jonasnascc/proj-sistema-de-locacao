package io.github.jonasnascimento.repository;

import io.github.jonasnascimento.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Contas extends JpaRepository<Conta, Integer> {

}
