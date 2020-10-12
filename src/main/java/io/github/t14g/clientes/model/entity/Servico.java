package io.github.t14g.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

//Configuração da tabela Serviço
@Entity
@Data
public class Servico {

    @Id //chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 155)
    private String descricao;

    @ManyToOne // Muitos serviços para um cliente, um cliente pode ter muitos serviços
    @JoinColumn(name = "id_cliente") //Chave estrângeira
    private Cliente cliente;

    @Column
    private BigDecimal valor; //valor do serviço
}
