package io.github.jonashnascimento;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocacaoApplication {
    @Bean
    public CommandLineRunner init(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(LocacaoApplication.class, args);
    }
}
