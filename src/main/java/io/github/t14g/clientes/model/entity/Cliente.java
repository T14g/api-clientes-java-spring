package io.github.t14g.clientes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

//Para dizer que é uma Entidade JPA
@Entity
//Construtores com e sem parâmetros gerados pelo Lombock
@NoArgsConstructor
@AllArgsConstructor
//Builder de cliente
//Com lombock em tempo de compilação tem os setters mad em Dev tem só a notation
//@Getter@Setter // vai gerar getters e setters automaticamente
@Data// Cria get e setters, hashing,entre outros
@Builder
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

    //Na hora que for persistir coloca a data atual, antes de persistir na verdade
    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }

}
