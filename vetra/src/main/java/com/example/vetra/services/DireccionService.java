package com.example.vetra.services;

import com.example.vetra.entities.Direccion;

import java.util.List;
import java.util.Optional;

public interface DireccionService {
    Direccion save(Direccion direccion);
    List<Direccion> findAll();
    Optional<Direccion> findById(Long id);
    Direccion update(Long id, Direccion direccion);
    void delete(Long id);
}