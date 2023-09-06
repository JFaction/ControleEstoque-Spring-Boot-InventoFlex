package com.InventoFlex.dto;

import com.InventoFlex.domain.Categorias;
import com.InventoFlex.domain.Fornecedor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO{
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
