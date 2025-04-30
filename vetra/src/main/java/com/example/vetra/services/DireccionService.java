package com.example.vetra.services;

import com.example.vetra.entities.Direccion;

import java.util.List;
import java.util.Optional;

public interface DireccionService {
    List<Direccion> findAll();
    Optional<Direccion> findById(Long id);
    Direccion save(Direccion direccion);
    void deleteById(Long id);
    Direccion update(Long id, Direccion direccion);
}