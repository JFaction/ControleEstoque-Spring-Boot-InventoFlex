package com.InventoFlex.domain;

import com.InventoFlex.dto.ProdutoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "produto")
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer quantidade;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categorias categoria;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id")
    private Fornecedor fornecedor;

    public Produto(ProdutoDTO produtoDTO, Categorias categorias, Fornecedor fornecedor){
        this.nome = produtoDTO.getNome();
        this.quantidade = produtoDTO.getQuantidade();
        this.valor = new BigDecimal(produtoDTO.getValor());
        this.categoria = categorias;
        this.fornecedor = fornecedor;
    }

}
