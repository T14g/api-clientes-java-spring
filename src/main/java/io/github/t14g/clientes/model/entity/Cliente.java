package io.github.t14g.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

//Para dizer que é uma Entidade JPA
@Entity
//Com lombock em tempo de compilação tem os setters mad em Dev tem só a notation
//@Getter@Setter // vai gerar getters e setters automaticamente
@Data// Cria get e setters, hashing,entre outros
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // o banco auto incrementa o ID
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_cadastro") //Em bancos usar _
    private LocalDate dataCadastro;

}
