package com.example.vetra.services.Impl;

import com.example.vetra.entities.Pedido;
import com.example.vetra.entities.PedidoItem;
import com.example.vetra.repositories.PedidoRepository;
import com.example.vetra.services.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    // El repo que nos da Spring para manejar los pedidos
    private final PedidoRepository pedidoRepository;

    // Trae todos los pedidos que hay en la base
    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    // Busca un pedido por ID, si no existe devuelve un Optional vacío
    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    // Guarda un pedido nuevo o actualiza uno existente
    @Override
    @Transactional
    public Pedido save(Pedido pedido) {
        // Validamos que el pedido tenga items
        if (pedido.getItems() == null || pedido.getItems().isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener al menos un item");
        }

        // Validamos que cada item tenga cantidad mayor a 0
        for (PedidoItem item : pedido.getItems()) {
            if (item.getCantidad() <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
            }
        }

        // Establecemos la fecha de creación si no está establecida
        if (pedido.getFechaCreacion() == null) {
            pedido.setFechaCreacion(LocalDateTime.now());
        }

        return pedidoRepository.save(pedido);
    }

    // Borra un pedido por ID, si no existe no hace nada
    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new EntityNotFoundException("No existe un pedido con el ID: " + id);
        }
        pedidoRepository.deleteById(id);
    }

    // Actualiza un pedido existente con los datos nuevos
    // Si no encuentra el pedido, tira una excepción
    @Override
    @Transactional
    public Pedido update(Long id, Pedido pedido) {
        Pedido existing = pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No existe un pedido con el ID: " + id));

        // Validamos que el pedido tenga items
        if (pedido.getItems() == null || pedido.getItems().isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener al menos un item");
        }

        // Validamos que cada item tenga cantidad mayor a 0
        for (PedidoItem item : pedido.getItems()) {
            if (item.getCantidad() <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
            }
        }

        // Actualizamos todos los campos con los datos nuevos
        existing.setUsuario(pedido.getUsuario());
        existing.setItems(pedido.getItems());
        existing.setEstado(pedido.getEstado());
        existing.setFechaCreacion(pedido.getFechaCreacion());

        // Guardamos los cambios y devolvemos el pedido actualizado
        return pedidoRepository.save(existing);
    }
}