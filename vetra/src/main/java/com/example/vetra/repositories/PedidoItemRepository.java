package com.example.vetra.repositories;

import com.example.vetra.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
    // Podrías añadir métodos como: List<PedidoItem> findByPedidoId(Long pedidoId);
} 