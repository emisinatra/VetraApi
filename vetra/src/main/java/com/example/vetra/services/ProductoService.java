package com.example.vetra.services;

import com.example.vetra.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto save(Producto producto);
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto update(Long id, Producto producto);
    void delete(Long id);
}