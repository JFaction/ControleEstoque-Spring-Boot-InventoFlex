package com.InventoFlex.domain;

import com.InventoFlex.dto.FornecedorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "fornecedores")
@Table(name = "fornecedores")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank()
    private String nome;
    @Column(unique = true)
    private String cnpj;
    private String cep;
    private String estado;
    private String municipio;
    private String logradouro;
    private String numero;

    public Fornecedor(FornecedorDTO fornecedorDTO){
        this.nome = fornecedorDTO.nome();
        this.cnpj = fornecedorDTO.cnpj();
        this.cep = fornecedorDTO.cep();
        this.estado = fornecedorDTO.estado();
        this.municipio = fornecedorDTO.municipio();
        this.logradouro = fornecedorDTO.logradouro();
        this.numero = fornecedorDTO.numero();
    }
}