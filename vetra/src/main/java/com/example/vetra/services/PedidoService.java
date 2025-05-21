package com.example.vetra.services;

import com.example.vetra.entities.Pedido;

public interface PedidoService extends BaseService<Pedido, Long> {
    // Si hay que hacer algo con los pedidos que sea muy particular y no esté en BaseService, se pone acá.
}