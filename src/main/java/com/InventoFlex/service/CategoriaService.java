package com.InventoFlex.service;

import com.InventoFlex.domain.Categorias;
import com.InventoFlex.dto.CategoriaDTO;
import com.InventoFlex.exception.ConstraintViolationException;
import com.InventoFlex.exception.ObjectNotFoundException;
import com.InventoFlex.exception.UniqueConstraintViolationException;
import com.InventoFlex.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriasRepository categoriasRepository;


    public Categorias findById(Integer id){
        Optional<Categorias> optionalCategorias = categoriasRepository.findById(id);
        return optionalCategorias.orElseThrow(() -> new ObjectNotFoundException(
                "Categoia não encontrada, ID: " + id));
    }

    public Categorias create(CategoriaDTO categoriaDTO){
        Categorias categoria = new Categorias(categoriaDTO);
        try{
            Categorias newCategoria = categoriasRepository.save(categoria);
            return newCategoria;
        }catch(Exception ex){
            throw new ConstraintViolationException(ex.toString());
        }
    }

    public Categorias update(Integer id, CategoriaDTO categoriaDTO){
        Categorias categorias = findById(id);
        updateData(categorias, categoriaDTO);
        return categoriasRepository.save(categorias);
    }

    public void updateData(Categorias categorias, CategoriaDTO categoriaDTO){
        categorias.setNome(categoriaDTO.nome());
        categorias.setDescricao(categoriaDTO.descricao());
    }

    public void delete(Integer id){
        Categorias categoria = findById(id);
        categoriasRepository.delete(categoria);
    }

    public List<Categorias> findAll() {
        List<Categorias> categorias = categoriasRepository.findAll();
        return categorias;
    }

}
