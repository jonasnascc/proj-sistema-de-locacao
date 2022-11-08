package io.github.jonasnascimento;

import io.github.jonasnascimento.model.Objeto;
import io.github.jonasnascimento.model.Tipo;
import io.github.jonasnascimento.repositorio.Objetos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocacaoApplication {

    @Bean
    public CommandLineRunner init(@Autowired Objetos objetos){
       return args -> {
           Tipo carro = new Tipo("Carro");
           Tipo apartamento = new Tipo("apartamento");
           Tipo casa = new Tipo("Casa");
           Tipo livro = new Tipo("livro");


           objetos.save(new Objeto(carro, "Corsa 2011"));
           System.out.println(objetos.findAll());

           objetos.save(new Objeto(apartamento, "apartamento 212"));
           System.out.println(objetos.findAll());

           objetos.deleteById(2);

           objetos.save(new Objeto(casa , "casa 87A"));

           objetos.save(new Objeto(livro, "Alice no país das maravilhas"));

           System.out.println(objetos.findAll());

           System.out.println(objetos.findByTipo(livro));
           //System.out.println(objetos.findByNomeTipo("Casa"));

           System.out.println(objetos.findAll());

           System.out.println("Fim");
       };
    }

    public static void main(String[] args) {
        SpringApplication.run(LocacaoApplication.class, args);
    }
}
