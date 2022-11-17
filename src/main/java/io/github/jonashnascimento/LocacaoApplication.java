package io.github.jonashnascimento;

import io.github.jonashnascimento.domain.entity.TipoObjeto;
import io.github.jonashnascimento.domain.repository.ObjetoRepository;
import io.github.jonashnascimento.domain.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocacaoApplication {
    @Bean
    public CommandLineRunner init(@Autowired ObjetoRepository objRepository, @Autowired TipoRepository tipoRepository){
        return args -> {
            TipoObjeto carro = new TipoObjeto();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(LocacaoApplication.class, args);
    }
}
