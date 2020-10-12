package io.github.t14g.clientes;

import io.github.t14g.clientes.model.entity.Cliente;
import io.github.t14g.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//Classe que inicializa Na raiz , nome do projeto + Application no final
//Essa anotation manda o springboot usar essa classe para inicializar a aplicação
//Essa anotation também configura toda injeção de dependências
@SpringBootApplication
public class ClientesApplication {

    //Injeção de dep no parâmetro do método
    //Código executado assim que inicializar a aplicação por ter @Bean
    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository){
        return  args -> {
            //O builder vai preenchendo como se fosse 1 formulário
            Cliente cliente = Cliente.builder().cpf("99999999999").nome("Fulano").build();
            repository.save(cliente);
        };
    }

    public static void main(String[] args) {
        //Incializa a aplicação
        SpringApplication.run(ClientesApplication.class, args);
    }
}
