package com.example.vetra.controllers;

import com.example.vetra.entities.OrdenCompra;
import com.example.vetra.services.Impl.OrdenCompraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordenes-compra")
//Esto permite que el front pueda hacer request, si no estuviera, al hacer una request lanzaria CORS error.
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class OrdenCompraController extends BaseControllerImpl<OrdenCompra, OrdenCompraServiceImpl> {

    @Autowired
    public OrdenCompraController(OrdenCompraServiceImpl ordenCompraService) {
        super(ordenCompraService);
    }

    // Acordate que los endpoints CRUD ya vienen de arriba, del BaseControllerImpl.
}