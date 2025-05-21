package com.example.vetra.services;

import com.example.vetra.entities.PedidoItem;

public interface PedidoItemService extends BaseService<PedidoItem, Long> {
    // Lo que sea específico para los ítems de pedido y no esté en BaseService, va acá.
} 