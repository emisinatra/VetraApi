package com.example.vetra.services;

import com.example.vetra.entities.PedidoItem;

import java.util.List;
import java.util.Optional;

public interface PedidoItemService {
    PedidoItem save(PedidoItem pedidoItem);
    List<PedidoItem> findAll(); 
    Optional<PedidoItem> findById(Long id);
    PedidoItem update(Long id, PedidoItem pedidoItem);
    void delete(Long id);
} 