package com.example.vetra.services;

import com.example.vetra.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    List<Usuario> findAll();
    Usuario update(Long id, Usuario usuario);
    void deleteById(Long id);
}