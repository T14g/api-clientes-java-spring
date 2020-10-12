package io.github.t14g.clientes.model.repository;

import io.github.t14g.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//Por dar extends no JpaRepository essa classe já se torna utilizável graças a injeção de dep
//<Qual a entidade que o repositório vai trabalhar, tipo de dado da chave primária>
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
