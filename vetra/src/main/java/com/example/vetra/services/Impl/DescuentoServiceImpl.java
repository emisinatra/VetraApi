package com.example.vetra.services.impl;

import com.example.vetra.entities.Descuento;
import com.example.vetra.repositories.DescuentoRepository;
import com.example.vetra.services.DescuentoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescuentoServiceImpl implements DescuentoService {

    private final DescuentoRepository descuentoRepository;

    public DescuentoServiceImpl(DescuentoRepository descuentoRepository) {
        this.descuentoRepository = descuentoRepository;
    }

    @Override
    public Descuento save(Descuento descuento) {
        return descuentoRepository.save(descuento);
    }

    @Override
    public List<Descuento> getAll() {
        return descuentoRepository.findAll();
    }

    @Override
    public Optional<Descuento> getById(Long id) {
        return descuentoRepository.findById(id);
    }

    @Override
    public Descuento update(Long id, Descuento updated) {
        return descuentoRepository.findById(id)
                .map(descuento -> {
                    descuento.setFechaInicio(updated.getFechaInicio());
                    descuento.setFechaCierre(updated.getFechaCierre());
                    descuento.setDescuento(updated.getDescuento());
                    return descuentoRepository.save(descuento);
                })
                .orElseThrow(() -> new RuntimeException("Descuento no encontrado con ID: " + id));
    }

    @Override
    public void delete(Long id) {
        descuentoRepository.deleteById(id);
    }
}