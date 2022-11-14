package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Locatario;
import io.github.jonashnascimento.domain.entity.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocatarioRepository extends JpaRepository<Locatario, Integer> {
}
