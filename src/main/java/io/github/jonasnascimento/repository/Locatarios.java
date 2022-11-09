package io.github.jonasnascimento.repositorio;

import io.github.jonasnascimento.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Locatarios extends JpaRepository<Locatario, Integer> {

}
