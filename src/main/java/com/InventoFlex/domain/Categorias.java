package com.InventoFlex.domain;

import com.InventoFlex.dto.CategoriaDTO;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "categorias")
@Entity(name = "categorias")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nullable
    private String nome;

    private String descricao;

    public Categorias(CategoriaDTO categoriaDTO) {
        this.nome = categoriaDTO.nome();
        this.descricao = categoriaDTO.descricao();
    }
}