package com.example.vetra.services.Impl;

import com.example.vetra.entities.Usuario;
import com.example.vetra.repositories.UsuarioRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }

    @Override
    public Usuario update(Long id, Usuario usuarioDetails) throws Exception {
        Usuario usuarioExistente = super.findById(id);
        
        usuarioExistente.setNombre(usuarioDetails.getNombre());
        usuarioExistente.setApellido(usuarioDetails.getApellido());
        usuarioExistente.setEmail(usuarioDetails.getEmail());
        usuarioExistente.setPassword(usuarioDetails.getPassword());
        usuarioExistente.setRol(usuarioDetails.getRol());
        
        return super.save(usuarioExistente);
    }
}