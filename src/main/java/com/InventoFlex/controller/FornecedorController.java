package com.InventoFlex.controller;

import com.InventoFlex.domain.Fornecedor;
import com.InventoFlex.dto.FornecedorDTO;
import com.InventoFlex.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Integer id){
        Fornecedor fornecedor = fornecedorService.findById(id);
        return ResponseEntity.ok().body(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll(){
        List<Fornecedor> fornecedor = fornecedorService.findAll();

        return ResponseEntity.ok().body(fornecedor);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> create(@Validated @RequestBody FornecedorDTO fornecedorDTO){
        Fornecedor fornecedor = fornecedorService.create(fornecedorDTO);
        return ResponseEntity.created(URI.create("/fornecedor/" + fornecedor.getId())).body(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Integer id,@RequestBody FornecedorDTO fornecedorDTO){
        Fornecedor fornecedor = fornecedorService.update(id, fornecedorDTO);
        return ResponseEntity.ok().body(fornecedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
