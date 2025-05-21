package com.example.vetra.repositories;

import com.example.vetra.entities.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {
}