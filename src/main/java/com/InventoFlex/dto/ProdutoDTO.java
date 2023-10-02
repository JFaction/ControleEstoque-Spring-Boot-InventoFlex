package com.InventoFlex.dto;

import com.InventoFlex.domain.Categorias;
import com.InventoFlex.domain.Fornecedor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProdutoDTO implements Serializable {

        @NotEmpty(message = "Campo NOME é Obrigatório")
        @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
        private String nome;
        private Integer quantidade;
        private String valor;
        private Integer categoria;
        private Integer fornecedor;


        public ProdutoDTO(String nome, Integer quantidade, String valor, Integer categoria, Integer fornecedor) {
                this.nome = nome;
                this.quantidade = quantidade;
                this.valor = valor;
                this.categoria = categoria;
                this.fornecedor = fornecedor;
        }

}
