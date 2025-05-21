package com.example.vetra.controllers;

import com.example.vetra.entities.Direccion;
import com.example.vetra.services.Impl.DireccionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/direcciones")
//Esto permite que el front pueda hacer request, si no estuviera, al hacer una request lanzaria CORS error.
@CrossOrigin(origins = "http://localhost:5173")
public class DireccionController extends BaseControllerImpl<Direccion, DireccionServiceImpl> {

    @Autowired
    public DireccionController(DireccionServiceImpl direccionService) {
        super(direccionService);
    }

    // Acordate que los endpoints CRUD ya vienen de arriba, del BaseControllerImpl.
}
