package com.example.vetra.services;

import com.example.vetra.entities.DetalleOrden;

import java.util.List;
import java.util.Optional;

public interface DetalleOrdenService {
    DetalleOrden save(DetalleOrden detalleOrden);
    Optional<DetalleOrden> findById(Long id);
    List<DetalleOrden> findByOrdenCompraId(Long ordenCompraId);
} 