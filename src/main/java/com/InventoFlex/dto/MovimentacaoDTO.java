package com.InventoFlex.dto;

import com.InventoFlex.domain.TipoMovimentacao;
import com.InventoFlex.domain.TipoPagamento;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovimentacaoDTO {
    private TipoMovimentacao tipoMovimentacao;
    private TipoPagamento tipoPagamento;
    private Integer produto;
    private Integer quantidade;
    private LocalDateTime data;

    public MovimentacaoDTO(TipoMovimentacao tipoMovimentacao, TipoPagamento tipoPagamento, Integer produto, Integer quantidade, LocalDateTime data) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.tipoPagamento = tipoPagamento;
        this.produto = produto;
        this.quantidade = quantidade;
        this.data = data;
    }

}
