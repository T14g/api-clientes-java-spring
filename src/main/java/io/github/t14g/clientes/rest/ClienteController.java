package io.github.t14g.clientes.rest;

import io.github.t14g.clientes.model.entity.Cliente;
import io.github.t14g.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

//Controlador Rest == receber requisições, enviar respostas HTTP rest
//tem o @ResponseBody que traz a resposta no formado que retornou sem ter que converter
@RestController
//URL base
@RequestMapping("/api/clientes")
public class ClienteController {

    //Final para que inicie  no construtor,constante, não muda
    private final ClienteRepository repository;

    //Dependência obrigatória injetada via construtor,  é a forma mais adequada, injetada na construção da classe
    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    //Mapeia o método para uma requisição POST, esse método vai salvar o cliente e retornar o mesmo salvo
    @PostMapping
    //Qual código de STATUS , 200 não precisa da notation, 201 === CREATED
    //@RequestBody indica que esse cliente é aquele json que vem no corpo a requisição
    //Isso irá converter o objeto Json em Objeto do Tipo Cliente
    @ResponseStatus(HttpStatus.CREATED)
    //@Valid faz a validação ocorrer pelo Spring e também no momento da requisição e não persistencia
    //Na persistencia ele já espera que tudo esteja válido
    public Cliente salvar(@RequestBody @Valid Cliente cliente){
        return repository.save(cliente);
    }


    //Se encontrar o cliente retorna código 200 + cliente se não retorna o código not found
    //{algo com variação} chaves === parâmetro api/clientes/123
    @GetMapping("{codigo}")
    public Cliente acharPorId(@PathVariable("codigo") Integer id ){
        //rest retorna 200 + recurso
        //Optional vai guardar um objeto ou não, é optional
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    //No content  indica que nada é retornado
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar( @PathVariable Integer id) {
        repository
                .findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    //Se retornasse null entraria na exception então retorne void
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    @PutMapping("{id}")
    //Não retornar nada
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
        repository
            .findById(id)
            .map(cliente -> {
                //Cliente atualizado recebe o ID do cliente encontrado
                clienteAtualizado.setId(cliente.getId());
                //Save ou atualiza caso já exista o ID ou salva novo caso não
                return repository.save(clienteAtualizado);
            })
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }
}
