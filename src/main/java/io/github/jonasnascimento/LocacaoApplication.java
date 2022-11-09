package io.github.jonasnascimento;

import io.github.jonasnascimento.model.Locador;
import io.github.jonasnascimento.model.Locatario;
import io.github.jonasnascimento.model.Objeto;
import io.github.jonasnascimento.model.Tipo;
import io.github.jonasnascimento.repository.Locadores;
import io.github.jonasnascimento.repository.Locatarios;
import io.github.jonasnascimento.repository.Objetos;
import io.github.jonasnascimento.repository.Tipos;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocacaoApplication {

    @Bean
    public CommandLineRunner init(@Autowired Objetos objetos, @Autowired Locadores locadores, @Autowired Locatarios locatarios, @Autowired Tipos tipos){
       return args -> {
           Tipo carro = new Tipo("Carro");
           Tipo apartamento = new Tipo("apartamento");
           Tipo casa = new Tipo("Casa");
           Tipo livro = new Tipo("livro");

           tipos.save(carro);
           tipos.save(apartamento);
           tipos.save(casa);
           tipos.save(livro);

           Objeto corsa = new Objeto(carro, "Corsa 2011");
           objetos.save(corsa);

           Locatario pedro = new Locatario("Pedro", "77895415466", "84 99587-3239");
           Locador joao = new Locador("Joao","12345678977","83874556877");
           locadores.save(joao);
           locatarios.save(pedro);

           corsa.setLocado_flag(true);
           corsa.setLocador(joao);
           corsa.setDono(pedro);


           objetos.save(new Objeto(apartamento, "apartamento 212"));
           objetos.save(new Objeto(casa , "casa 87A"));
           objetos.save(new Objeto(livro, "Alice no país das maravilhas"));



           objetos.save(corsa);

           Locador locador = locadores.findLocadorFetchObjetos(joao.getId());

           objetos.findByLocador(joao).forEach(System.out::println);

           System.out.println(locador.getObjetosAlugados());




           System.out.println("Fim");
       };
    }

    public static void main(String[] args) {
        SpringApplication.run(LocacaoApplication.class, args);
    }
}
