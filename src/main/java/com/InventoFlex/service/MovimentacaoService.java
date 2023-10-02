package com.InventoFlex.service;

import com.InventoFlex.domain.Movimentacao;
import com.InventoFlex.domain.Produto;
import com.InventoFlex.domain.TipoMovimentacao;
import com.InventoFlex.dto.MovimentacaoDTO;
import com.InventoFlex.exception.ObjectNotFoundException;
import com.InventoFlex.repository.MovimentacaoRepository;
import com.InventoFlex.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    ProdutoService produtoService;
    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    public Movimentacao create(MovimentacaoDTO movimentacaoDTO){
        Produto produto = produtoService.findById(movimentacaoDTO.getProduto());
        movimentacaoDTO.setData(LocalDateTime.now());

        if(movimentacaoDTO.getTipoMovimentacao() == TipoMovimentacao.SAIDA){
            if(produto.getQuantidade() >= movimentacaoDTO.getQuantidade()){
                produto.setQuantidade( produto.getQuantidade() - movimentacaoDTO.getQuantidade());
            }else{
                throw new ObjectNotFoundException("Quantidade da movimentação excede a quantidade do item");
            }
        }else{
            produto.setQuantidade( produto.getQuantidade() + movimentacaoDTO.getQuantidade());
        }



        Movimentacao movimentacao = new Movimentacao(movimentacaoDTO, produto);

        return movimentacaoRepository.save(movimentacao);
    }



    public Movimentacao findById(Integer id){
        Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
        return movimentacao.orElseThrow(() ->
                new ObjectNotFoundException("Movimentação não encontrada, ID: " + id));
    }

    public List<Movimentacao> findAll(){
        return movimentacaoRepository.findAll();
    }

}
