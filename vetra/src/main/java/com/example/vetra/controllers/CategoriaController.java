package com.example.vetra.controllers;

import com.example.vetra.entities.Categoria;
import com.example.vetra.services.Impl.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorias")
// Esto permite que el front pueda hacer request, si no estuviera, al hacer una request lanzaria CORS error.
@CrossOrigin(origins = "http://localhost:5173")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl> {

    @Autowired
    public CategoriaController(CategoriaServiceImpl categoriaService) {
        super(categoriaService);
    }
} 