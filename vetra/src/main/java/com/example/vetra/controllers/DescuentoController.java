package com.example.vetra.controllers;

import com.example.vetra.entities.Descuento;
import com.example.vetra.services.Impl.DescuentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/descuentos")
//Esto permite que el front pueda hacer request, si no estuviera, al hacer una request lanzaria CORS error.
@CrossOrigin(origins = "http://localhost:5173")
public class DescuentoController extends BaseControllerImpl<Descuento, DescuentoServiceImpl> {

    @Autowired
    public DescuentoController(DescuentoServiceImpl descuentoService) {
        super(descuentoService);
    }
}