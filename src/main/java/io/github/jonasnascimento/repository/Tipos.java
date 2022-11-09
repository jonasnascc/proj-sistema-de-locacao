package io.github.jonasnascimento.repository;

import io.github.jonasnascimento.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tipos extends JpaRepository<Tipo, String> {
}
