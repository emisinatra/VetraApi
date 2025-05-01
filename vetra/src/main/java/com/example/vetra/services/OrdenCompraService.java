package com.example.vetra.services;

import com.example.vetra.entities.OrdenCompra;

import java.util.List;
import java.util.Optional;

public interface OrdenCompraService {
    List<OrdenCompra> findAll();
    Optional<OrdenCompra> findById(Long id);
    OrdenCompra save(OrdenCompra ordenCompra);
    void deleteById(Long id);
    OrdenCompra update(Long id, OrdenCompra ordenCompra);
}