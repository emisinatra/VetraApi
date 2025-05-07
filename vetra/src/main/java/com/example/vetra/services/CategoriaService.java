package com.example.vetra.services;

import com.example.vetra.entities.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Categoria save(Categoria categoria);
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Categoria update(Long id, Categoria categoria);
    void delete(Long id);
} 