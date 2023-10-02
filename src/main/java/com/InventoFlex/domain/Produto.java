package com.InventoFlex.domain;

import com.InventoFlex.dto.ProdutoDTO;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Campo NOME é Obrigatório")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    private Integer quantidade;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id", nullable = true)
    private Categorias categoria;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", referencedColumnName = "id", nullable = true)
    private Fornecedor fornecedor;

    public Produto(ProdutoDTO produtoDTO, Categorias categorias, Fornecedor fornecedor){
        this.nome = produtoDTO.getNome();
        this.quantidade = produtoDTO.getQuantidade();
        this.valor = new BigDecimal(produtoDTO.getValor());
        this.categoria = categorias;
        this.fornecedor = fornecedor;
    }

}
