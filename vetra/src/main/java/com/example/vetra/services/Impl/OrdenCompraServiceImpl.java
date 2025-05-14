package com.example.vetra.services.Impl;

import com.example.vetra.entities.OrdenCompra;
import com.example.vetra.repositories.OrdenCompraRepository;
import com.example.vetra.services.OrdenCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdenCompraServiceImpl implements OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;

    @Override
    public List<OrdenCompra> findAll() {
        return ordenCompraRepository.findAll();
    }

    @Override
    public Optional<OrdenCompra> findById(Long id) {
        return ordenCompraRepository.findById(id);
    }

    @Override
    public OrdenCompra save(OrdenCompra ordenCompra) {
        // Establecemos la fecha de la orden si no está establecida
        if (ordenCompra.getFechaOrden() == null) {
            ordenCompra.setFechaOrden(LocalDateTime.now());
        }
        return ordenCompraRepository.save(ordenCompra);
    }

    @Override
    public void deleteById(Long id) {
        ordenCompraRepository.deleteById(id);
    }

    @Override
    public OrdenCompra update(Long id, OrdenCompra ordenCompra) {
        OrdenCompra existing = ordenCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrdenCompra no encontrada con id: " + id));

        existing.setPedido(ordenCompra.getPedido());
        existing.setFechaOrden(ordenCompra.getFechaOrden());
        existing.setMontoTotal(ordenCompra.getMontoTotal());
        existing.setMedioPago(ordenCompra.getMedioPago());

        return ordenCompraRepository.save(existing);
    }
}