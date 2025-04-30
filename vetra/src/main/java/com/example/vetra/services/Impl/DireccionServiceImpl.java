package com.example.vetra.services.Impl;

import com.example.vetra.entities.Direccion;
import com.example.vetra.repositories.DireccionRepository;
import com.example.vetra.services.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository direccionRepository;

    @Override
    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    @Override
    public Optional<Direccion> findById(Long id) {
        return direccionRepository.findById(id);
    }

    @Override
    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public void deleteById(Long id) {
        direccionRepository.deleteById(id);
    }

    @Override
    public Direccion update(Long id, Direccion direccion) {
        return direccionRepository.findById(id).map(existing -> {
            existing.setCalle(direccion.getCalle());
            existing.setCodpost(direccion.getCodpost());
            return direccionRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Dirección no encontrada"));
    }
}