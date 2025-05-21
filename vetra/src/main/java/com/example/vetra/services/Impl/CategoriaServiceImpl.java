package com.example.vetra.services.Impl;

import com.example.vetra.entities.Categoria;
import com.example.vetra.repositories.CategoriaRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService {

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
    }

    @Override
    public Categoria update(Long id, Categoria categoriaDetails) throws Exception {
        Categoria categoriaExistente = super.findById(id);
        categoriaExistente.setNombre(categoriaDetails.getNombre());
        return super.save(categoriaExistente);
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return super.delete(id);
    }
} 