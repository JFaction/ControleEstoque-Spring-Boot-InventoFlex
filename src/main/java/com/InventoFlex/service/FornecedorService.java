package com.InventoFlex.service;

import com.InventoFlex.domain.Fornecedor;
import com.InventoFlex.dto.FornecedorDTO;
import com.InventoFlex.exception.DataIntegrityViolationException;
import com.InventoFlex.exception.ObjectNotFoundException;
import com.InventoFlex.exception.UniqueConstraintViolationException;
import com.InventoFlex.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }
    public Fornecedor create(FornecedorDTO fornecedorDTO){
        try{
            Fornecedor fornecedor = new Fornecedor(fornecedorDTO);
            return fornecedorRepository.save(fornecedor);
        }catch(Exception ex){
            throw new UniqueConstraintViolationException("O campo CNPJ é unico");
        }
    }

    public Fornecedor update(Integer id,FornecedorDTO fornecedorDTO){
        Fornecedor fornecedor = findById(id);
        updateData(fornecedor,fornecedorDTO);

        return fornecedorRepository.save(fornecedor);
    }

    public void delete(Integer id){
        Fornecedor obj = findById(id);
        fornecedorRepository.delete(obj);
    }

    public Fornecedor findById(Integer id){
        Optional<Fornecedor> optionalFornecedor = fornecedorRepository.findById(id);
        return optionalFornecedor.orElseThrow(() -> new ObjectNotFoundException(
                "Fornecedor não encontrado, ID: " + id));
    }

    public void updateData(Fornecedor obj, FornecedorDTO dto){
        obj.setNome(dto.nome());
        obj.setCnpj(dto.cnpj());
        obj.setCep(dto.cep());
        obj.setEstado(dto.estado());
        obj.setMunicipio(dto.municipio());
        obj.setLogradouro(dto.logradouro());
        obj.setNumero(dto.numero());
    }


}
