package com.example.vetra.services;

import com.example.vetra.entities.Descuento;

import java.util.List;
import java.util.Optional;

public interface DescuentoService {
    Descuento save(Descuento descuento);
    List<Descuento> getAll();
    Optional<Descuento> getById(Long id);
    Descuento update(Long id, Descuento descuento);
    void delete(Long id);
}