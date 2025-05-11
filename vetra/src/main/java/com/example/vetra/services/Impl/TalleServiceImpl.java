package com.example.vetra.services.Impl;

import com.example.vetra.entities.Talle;
import com.example.vetra.repositories.TalleRepository;
import com.example.vetra.services.TalleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TalleServiceImpl implements TalleService {

    // Acá guardamos el repo que nos da Spring por inyección de dependencias
    private final TalleRepository talleRepository;

    // Este método trae todos los talles que hay en la base
    @Override
    public List<Talle> findAll() {
        return talleRepository.findAll();
    }

    // Buscamos un talle por ID, si no existe devuelve un Optional vacío
    @Override
    public Optional<Talle> findById(Long id) {
        return talleRepository.findById(id);
    }

    // Guardamos un talle nuevo o actualizamos uno existente
    @Override
    public Talle save(Talle talle) {
        return talleRepository.save(talle);
    }

    // Borramos un talle por ID, si no existe no hace nada
    @Override
    public void deleteById(Long id) {
        talleRepository.deleteById(id);
    }
}
