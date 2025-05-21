package com.example.vetra.services;

import com.example.vetra.entities.DetalleOrden;

import java.util.List;

public interface DetalleOrdenService extends BaseService<DetalleOrden, Long> {
    // Acordate que los métodos comunes (findAll, save, etc.) ya vienen de BaseService.
    List<DetalleOrden> findByOrdenCompraId(Long ordenCompraId) throws Exception;
} 