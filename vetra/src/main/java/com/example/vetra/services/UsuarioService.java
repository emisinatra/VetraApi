package com.example.vetra.services;

import com.example.vetra.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService extends BaseService<Usuario, Long> {
    // Si hay que hacer algo específico con usuarios que no esté en BaseService, lo ponemos acá.
}