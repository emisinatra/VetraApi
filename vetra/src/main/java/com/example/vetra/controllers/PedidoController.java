package com.example.vetra.controllers;

import com.example.vetra.entities.Pedido;
import com.example.vetra.services.Impl.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "http://localhost:5173")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {

    @Autowired
    public PedidoController(PedidoServiceImpl pedidoService) {
        super(pedidoService);
    }

    // Acordate que los endpoints CRUD ya vienen de arriba, del BaseControllerImpl.
}