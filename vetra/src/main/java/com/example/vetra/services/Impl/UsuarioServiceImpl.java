package com.example.vetra.services.Impl;

import com.example.vetra.entities.Usuario;
import com.example.vetra.repositories.UsuarioRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        super(usuarioRepository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario save(Usuario usuario) throws Exception {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return super.save(usuario);
    }

    @Override
    public Usuario update(Long id, Usuario usuarioDetails) throws Exception {
        Usuario usuarioExistente = super.findById(id);
        
        usuarioExistente.setNombre(usuarioDetails.getNombre());
        usuarioExistente.setApellido(usuarioDetails.getApellido());
        usuarioExistente.setEmail(usuarioDetails.getEmail());
        
        if (usuarioDetails.getPassword() != null && !usuarioDetails.getPassword().isEmpty()) {
            usuarioExistente.setPassword(usuarioDetails.getPassword());
        }
        
        usuarioExistente.setRol(usuarioDetails.getRol());
        
        return super.save(usuarioExistente);
    }
}