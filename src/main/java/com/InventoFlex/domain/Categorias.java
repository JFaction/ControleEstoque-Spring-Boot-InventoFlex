package com.InventoFlex.domain;

import com.InventoFlex.dto.CategoriaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "categorias")
@Entity(name = "categorias")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O campo nome não pode estar em branco")
    private String nome;

    private String descricao;

    public Categorias(CategoriaDTO categoriaDTO) {
        this.nome = categoriaDTO.nome();
        this.descricao = categoriaDTO.descricao();
    }
}