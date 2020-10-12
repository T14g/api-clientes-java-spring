package io.github.t14g.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Classe que inicializa Na raiz , nome do projeto + Application no final
//Essa anotation manda o springboot usar essa classe para inicializar a aplicação
//Essa anotation também configura toda injeção de dependências
@SpringBootApplication
public class ClientesApplication {
    public static void main(String[] args) {
        //Incializa a aplicação
        SpringApplication.run(ClientesApplication.class, args);
    }
}
