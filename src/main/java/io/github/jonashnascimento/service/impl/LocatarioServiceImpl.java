package io.github.jonashnascimento.service.impl;

import io.github.jonashnascimento.domain.entity.Locatario;
import io.github.jonashnascimento.domain.repository.LocatarioRepository;
import io.github.jonashnascimento.exception.RegraNegocioException;
import io.github.jonashnascimento.service.LocatarioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocatarioServiceImpl implements LocatarioService {

    private final LocatarioRepository repository;
    @Override
    public Optional<Locatario> obterLocatarioCompleto(Integer id) {
        return repository.findLocatarioFetchObjetos(id);
    }
}
