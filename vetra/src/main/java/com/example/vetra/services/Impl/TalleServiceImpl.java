package com.example.vetra.services.Impl;

import com.example.vetra.entities.Talle;
import com.example.vetra.repositories.TalleRepository;
import com.example.vetra.services.TalleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TalleServiceImpl implements TalleService {

    private final TalleRepository talleRepository;

    @Override
    public List<Talle> getAll() {
        return talleRepository.findAll();
    }

    @Override
    public Talle getById(Long id) {
        return talleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Talle no encontrado con ID: " + id));
    }

    @Override
    public Talle create(Talle talle) {
        return talleRepository.save(talle);
    }

    @Override
    public Talle update(Long id, Talle talle) {
        Talle existing = getById(id);
        existing.setTalle(talle.getTalle());
        return talleRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        talleRepository.deleteById(id);
    }
}
