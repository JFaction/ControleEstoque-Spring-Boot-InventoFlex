package com.InventoFlex.service;

import com.InventoFlex.domain.Categorias;
import com.InventoFlex.domain.Fornecedor;
import com.InventoFlex.domain.Produto;
import com.InventoFlex.dto.ProdutoDTO;
import com.InventoFlex.exception.ObjectNotFoundException;
import com.InventoFlex.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    FornecedorService fornecedorService;

    public Produto create(ProdutoDTO produto){

        Categorias categoria = categoriaService.findById(produto.getCategoria());

        Fornecedor fornecedor = fornecedorService.findById(produto.getFornecedor());

        String valorFormatado = "0";

        produto.setValor(produto.getValor().replace(",","."));

        Produto newProduto = new Produto(produto, categoria, fornecedor);

        return produtoRepository.save(newProduto);

    }

    public Produto update(Integer id, ProdutoDTO produtoDTO){
        Produto produto = findById(id);
        UpdateData(produto, produtoDTO);
        return produtoRepository.save(produto);
    }

    public void delete(Integer id){
        Produto produto = findById(id);
        produtoRepository.delete(produto);
    }

    public void UpdateData(Produto produto, ProdutoDTO produtoDTO){
        produto.setNome(produtoDTO.getNome());

        produtoDTO.setValor(produtoDTO.getValor().replace(",","."));
        produto.setValor( new BigDecimal(produtoDTO.getValor()));

        produto.setQuantidade(produtoDTO.getQuantidade());
        produto.setCategoria(categoriaService.findById(produtoDTO.getCategoria()));
        produto.setFornecedor(fornecedorService.findById(produtoDTO.getFornecedor()));
    }

    public Produto findById(Integer id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() ->
                new ObjectNotFoundException("Produto não foi encontrado, ID: " + id));
    }

    public List<Produto> findAll(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

}