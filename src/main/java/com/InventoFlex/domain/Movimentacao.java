package com.InventoFlex.domain;

import com.InventoFlex.dto.MovimentacaoDTO;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "movimentacao")
@Table(name = "movimentacao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id", nullable = true)
    private Produto produto;
    private Integer quantidade;
    private LocalDateTime data;

    public Movimentacao(MovimentacaoDTO movimentacaoDTO, Produto produto){
        this.tipoMovimentacao = movimentacaoDTO.getTipoMovimentacao();
        this.tipoPagamento = movimentacaoDTO.getTipoPagamento();
        this.produto = produto;
        this.quantidade = movimentacaoDTO.getQuantidade();
        this.data = movimentacaoDTO.getData();
    }

}