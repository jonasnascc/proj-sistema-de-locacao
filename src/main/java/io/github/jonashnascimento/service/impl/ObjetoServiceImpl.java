package io.github.jonashnascimento.service.impl;

import io.github.jonashnascimento.domain.repository.ObjetoRepository;
import io.github.jonashnascimento.service.ObjetoService;
import org.springframework.stereotype.Service;

@Service
public class ObjetoServiceImpl implements ObjetoService {

    private ObjetoRepository repository;

    public ObjetoServiceImpl(ObjetoRepository repository){
        this.repository = repository;
    }
}
