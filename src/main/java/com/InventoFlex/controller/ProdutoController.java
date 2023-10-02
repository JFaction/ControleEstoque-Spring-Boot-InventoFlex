package com.InventoFlex.controller;


import com.InventoFlex.domain.Produto;
import com.InventoFlex.dto.ProdutoDTO;
import com.InventoFlex.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> create(@Valid @RequestBody ProdutoDTO produto){
        Produto newProduto = produtoService.create(produto);
        return ResponseEntity.created(URI.create("/produto/" + newProduto.getId())).body(newProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody ProdutoDTO produtoDTO){
        Produto produto = produtoService.update(id, produtoDTO);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id){
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping()
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> produto = produtoService.findAll();
        return ResponseEntity.ok().body(produto);
    }

}