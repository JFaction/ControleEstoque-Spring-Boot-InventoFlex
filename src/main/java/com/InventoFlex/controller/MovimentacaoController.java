package com.InventoFlex.controller;

import com.InventoFlex.domain.Movimentacao;
import com.InventoFlex.dto.MovimentacaoDTO;
import com.InventoFlex.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movimentacao")
@CrossOrigin(origins = "http://localhost:4200")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<Movimentacao> create(@RequestBody MovimentacaoDTO movimentacaoDTO){
        Movimentacao movimentacao = movimentacaoService.create(movimentacaoDTO);
        return ResponseEntity.created(URI.create("/movimentacao/" + movimentacao.getId())).body(movimentacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> findById(@PathVariable Integer id){
        Movimentacao movimentacao = movimentacaoService.findById(id);
        return ResponseEntity.ok().body(movimentacao);
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> findAll(){
        List<Movimentacao> movimentacao = movimentacaoService.findAll();
        return ResponseEntity.ok().body(movimentacao);
    }



}
