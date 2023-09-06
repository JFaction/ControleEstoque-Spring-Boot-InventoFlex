package com.InventoFlex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.InventoFlex.domain.Categorias;

import java.util.List;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {

    List<Categorias> findAll();

}
