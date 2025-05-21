package com.example.vetra.services.Impl;

import com.example.vetra.entities.Pedido;
import com.example.vetra.entities.PedidoItem;
import com.example.vetra.repositories.PedidoRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        super(pedidoRepository);
    }

    @Override
    @Transactional
    public Pedido save(Pedido pedido) throws Exception {
        validatePedidoItems(pedido);
        if (pedido.getFechaCreacion() == null) {
            pedido.setFechaCreacion(LocalDateTime.now());
        }
        return super.save(pedido);
    }

    @Override
    @Transactional
    public Pedido update(Long id, Pedido pedidoDetails) throws Exception {
        Pedido pedidoExistente = super.findById(id);
        
        validatePedidoItems(pedidoDetails);

        pedidoExistente.setUsuario(pedidoDetails.getUsuario());
        pedidoExistente.setItems(pedidoDetails.getItems());
        pedidoExistente.setEstado(pedidoDetails.getEstado());
        pedidoExistente.setFechaCreacion(pedidoDetails.getFechaCreacion());

        return super.save(pedidoExistente);
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        return super.delete(id);
    }

    private void validatePedidoItems(Pedido pedido) {
        if (pedido.getItems() == null || pedido.getItems().isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener al menos un item");
        }
        for (PedidoItem item : pedido.getItems()) {
            if (item.getCantidad() <= 0) {
                throw new IllegalArgumentException("La cantidad del item debe ser mayor a 0");
            }
        }
    }
}