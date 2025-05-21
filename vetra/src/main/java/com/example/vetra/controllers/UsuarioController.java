package com.example.vetra.controllers;

import com.example.vetra.entities.Usuario;
import com.example.vetra.services.Impl.UsuarioServiceImpl;
import com.example.vetra.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

    @Autowired
    public UsuarioController(UsuarioServiceImpl usuarioService) {
        super(usuarioService);
    }
}