package com.example.vetra.services.Impl;

import com.example.vetra.entities.OrdenCompra;
import com.example.vetra.entities.DetalleOrden;
import com.example.vetra.repositories.OrdenCompraRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrdenCompraServiceImpl extends BaseServiceImpl<OrdenCompra, Long> implements OrdenCompraService {

    @Autowired
    public OrdenCompraServiceImpl(OrdenCompraRepository ordenCompraRepository) {
        super(ordenCompraRepository);
    }

    // Acordate que findAll() y findById() ya vienen de arriba.

    @Override
    @Transactional
    public OrdenCompra save(OrdenCompra ordenCompra) throws Exception {
        validateDetallesOrden(ordenCompra);
        if (ordenCompra.getFechaOrden() == null) {
            ordenCompra.setFechaOrden(LocalDateTime.now());
        }

        for (DetalleOrden detalle : ordenCompra.getDetalles()) {
            detalle.setOrdenCompra(ordenCompra);
        }

        // Podríamos recalcular el monto total aquí para asegurar consistencia
        // ordenCompra.calcularMontoTotal();
        return super.save(ordenCompra);
    }

    @Override
    @Transactional
    public OrdenCompra update(Long id, OrdenCompra ordenCompraDetails) throws Exception {
        OrdenCompra ordenCompraExistente = super.findById(id);
        
        validateDetallesOrden(ordenCompraDetails);

        ordenCompraExistente.getDetalles().clear();
        for (DetalleOrden detalle : ordenCompraDetails.getDetalles()) {
            detalle.setOrdenCompra(ordenCompraExistente);
            ordenCompraExistente.getDetalles().add(detalle);
        }

        ordenCompraExistente.setPedido(ordenCompraDetails.getPedido());
        ordenCompraExistente.setFechaOrden(ordenCompraDetails.getFechaOrden());
        ordenCompraExistente.setMontoTotal(ordenCompraDetails.getMontoTotal());
        ordenCompraExistente.setMedioPago(ordenCompraDetails.getMedioPago());
        
        return super.save(ordenCompraExistente);
    }

    private void validateDetallesOrden(OrdenCompra ordenCompra) {
        if (ordenCompra.getDetalles() == null || ordenCompra.getDetalles().isEmpty()) {
            throw new IllegalArgumentException("La orden de compra debe tener al menos un detalle");
        }
        for (DetalleOrden detalle : ordenCompra.getDetalles()) {
            if (detalle.getCantidad() <= 0) {
                throw new IllegalArgumentException("La cantidad en el detalle de la orden debe ser mayor a 0");
            }
            if (detalle.getPrecioUnitario() <= 0) {
                throw new IllegalArgumentException("El precio unitario en el detalle de la orden debe ser mayor a 0");
            }
        }
    }

    // El delete() ya lo tenemos de BaseServiceImpl y debería andar bien si no hay cosas raras que hacer al borrar.
}