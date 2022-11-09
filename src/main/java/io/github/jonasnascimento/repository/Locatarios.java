package io.github.jonasnascimento.repository;

import io.github.jonasnascimento.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Locatarios extends JpaRepository<Locatario, Integer> {

}
