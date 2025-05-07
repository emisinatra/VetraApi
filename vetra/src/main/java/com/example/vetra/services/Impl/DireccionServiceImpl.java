package com.example.vetra.services.Impl;

import com.example.vetra.entities.Direccion;
import com.example.vetra.repositories.DireccionRepository;
import com.example.vetra.services.DireccionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DireccionServiceImpl implements DireccionService {

    private final DireccionRepository direccionRepository;

    @Override
    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    @Override
    public Optional<Direccion> findById(Long id) {
        return direccionRepository.findById(id);
    }

    @Override
    public Direccion update(Long id, Direccion direccion) {
        Direccion existingDireccion = direccionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dirección no encontrada con ID: " + id));
        existingDireccion.setCalle(direccion.getCalle());
        existingDireccion.setCodpost(direccion.getCodpost());
        // Actualizar otros campos si los añades
        return direccionRepository.save(existingDireccion);
    }

    @Override
    public void delete(Long id) {
        if (!direccionRepository.existsById(id)) {
            throw new EntityNotFoundException("Dirección no encontrada con ID: " + id);
        }
        direccionRepository.deleteById(id);
    }
}