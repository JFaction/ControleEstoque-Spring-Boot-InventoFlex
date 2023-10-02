package com.InventoFlex.controller;

import com.InventoFlex.domain.Categorias;
import com.InventoFlex.dto.CategoriaDTO;
import com.InventoFlex.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categorias> create(@Validated @RequestBody CategoriaDTO categoriaDto){
        Categorias categoria = categoriaService.create(categoriaDto);
        return ResponseEntity.created(URI.create("/categoria/" + categoria.getId())).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorias> update(@Validated @PathVariable Integer id, @RequestBody  CategoriaDTO categoriaDTO){
        Categorias categoria = categoriaService.update(id, categoriaDTO);
        return ResponseEntity.ok().body(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
       categoriaService.delete(id);
       return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Categorias>> findAll(){
        List<Categorias> categorias  = categoriaService.findAll();
        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> findById(@PathVariable Integer id){
        Categorias categorias = categoriaService.findById(id);
        return ResponseEntity.ok().body(categorias);
    }

}
