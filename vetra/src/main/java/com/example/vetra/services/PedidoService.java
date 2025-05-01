package com.example.vetra.services;

import com.example.vetra.entities.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> findAll();
    Optional<Pedido> findById(Long id);
    Pedido save(Pedido pedido);
    void deleteById(Long id);
    Pedido update(Long id, Pedido pedido);
}