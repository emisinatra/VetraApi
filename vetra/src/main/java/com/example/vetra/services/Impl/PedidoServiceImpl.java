package com.example.vetra.services.Impl;

import com.example.vetra.entities.Pedido;
import com.example.vetra.repositories.PedidoRepository;
import com.example.vetra.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido update(Long id, Pedido pedido) {
        Pedido existing = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + id));

        existing.setUsuario(pedido.getUsuario());
        existing.setProductos(pedido.getProductos());
        existing.setEstado(pedido.getEstado());
        existing.setFechaCreacion(pedido.getFechaCreacion());

        return pedidoRepository.save(existing);
    }
}