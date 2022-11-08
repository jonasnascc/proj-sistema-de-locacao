package io.github.jonasnascimento.repositorio;

import io.github.jonasnascimento.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tipos extends JpaRepository<Tipo, String> {
}
