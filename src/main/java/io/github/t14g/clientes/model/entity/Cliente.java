package io.github.t14g.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF
    private String cpf;

    @Column(name = "data_cadastro", updatable = false) //Em bancos usar _
    //Parece ser o retorno do json no lado do Client
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    //Na hora que for persistir coloca a data atual, antes de persistir na verdade
    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }

}
