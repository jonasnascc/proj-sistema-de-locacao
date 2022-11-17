package io.github.jonashnascimento.domain.repository;

import io.github.jonashnascimento.domain.entity.Locador;
import io.github.jonashnascimento.domain.entity.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocatarioRepository extends JpaRepository<Locatario, Integer> {
    Locador findLocatarioByCpf(String cpf);

}
