package com.example.vetra.services.Impl;

import com.example.vetra.entities.DetalleOrden;
import com.example.vetra.repositories.DetalleOrdenRepository;
import com.example.vetra.services.DetalleOrdenService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleOrdenServiceImpl implements DetalleOrdenService {

    private final DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        // Aquí se podría verificar el stock del producto y actualizarlo
        // También se podría asegurar que el precioUnitario sea el correcto del producto en ese momento
        return detalleOrdenRepository.save(detalleOrden);
    }

    @Override
    public Optional<DetalleOrden> findById(Long id) {
        return detalleOrdenRepository.findById(id);
    }

    @Override
    public List<DetalleOrden> findByOrdenCompraId(Long ordenCompraId) {
        return detalleOrdenRepository.findByOrdenCompraId(ordenCompraId);
    }

    // Los métodos update y delete para DetalleOrden usualmente no se implementan
    // ya que los detalles de una orden confirmada suelen ser inmutables.
    // Si se necesita modificar una orden, generalmente se cancela la existente y se crea una nueva.
} 