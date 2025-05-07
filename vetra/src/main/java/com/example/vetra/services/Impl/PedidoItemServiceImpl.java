package com.example.vetra.services.Impl;

import com.example.vetra.entities.PedidoItem;
import com.example.vetra.repositories.PedidoItemRepository;
import com.example.vetra.services.PedidoItemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoItemServiceImpl implements PedidoItemService {

    private final PedidoItemRepository pedidoItemRepository;

    @Override
    public PedidoItem save(PedidoItem pedidoItem) {
        // Aquí podrías añadir lógica de validación, ej. stock del producto
        return pedidoItemRepository.save(pedidoItem);
    }

    @Override
    public List<PedidoItem> findAll() {
        return pedidoItemRepository.findAll();
    }

    @Override
    public Optional<PedidoItem> findById(Long id) {
        return pedidoItemRepository.findById(id);
    }

    @Override
    public PedidoItem update(Long id, PedidoItem pedidoItem) {
        PedidoItem existingItem = pedidoItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PedidoItem no encontrado con ID: " + id));
        // Solo permitir actualizar la cantidad por ejemplo
        existingItem.setCantidad(pedidoItem.getCantidad()); 
        // Asegurarse que no se cambie el producto o el pedido al que pertenece desde aquí
        return pedidoItemRepository.save(existingItem);
    }

    @Override
    public void delete(Long id) {
        if (!pedidoItemRepository.existsById(id)) {
            throw new EntityNotFoundException("PedidoItem no encontrado con ID: " + id);
        }
        pedidoItemRepository.deleteById(id);
    }

    // Implementación de findByPedidoId si se añade a la interfaz
    // @Override
    // public List<PedidoItem> findByPedidoId(Long pedidoId) {
    // return pedidoItemRepository.findByPedidoId(pedidoId); // Necesitaría este método en el repo
    // }
} 