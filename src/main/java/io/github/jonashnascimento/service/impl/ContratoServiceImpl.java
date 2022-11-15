package io.github.jonashnascimento.service.impl;


import io.github.jonashnascimento.domain.repository.ContratoRepository;
import io.github.jonashnascimento.service.ContratoService;
import org.springframework.stereotype.Service;

@Service
public class ContratoServiceImpl implements ContratoService {
    private ContratoRepository repository;

    public ContratoServiceImpl(ContratoRepository repository) {
        this.repository = repository;
    }
}
