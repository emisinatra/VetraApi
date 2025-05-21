package com.example.vetra.repositories;

import com.example.vetra.entities.PedidoItem;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends BaseRepository<PedidoItem, Long> {
    // Ojo, acá podríamos meter un método para buscar items por pedido, onda List<PedidoItem> findByPedidoId(Long pedidoId);
} 