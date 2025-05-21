package com.example.vetra.services.Impl;

import com.example.vetra.entities.OrdenCompra;
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
        if (ordenCompra.getFechaOrden() == null) {
            ordenCompra.setFechaOrden(LocalDateTime.now());
        }
        // Acá podríamos meterle pata al cálculo del montoTotal, ya sea llamando
        // al método que teníamos en la entidad (si lo activamos de nuevo) o haciéndolo acá mismo.
        return super.save(ordenCompra);
    }

    @Override
    @Transactional
    public OrdenCompra update(Long id, OrdenCompra ordenCompraDetails) throws Exception {
        OrdenCompra ordenCompraExistente = super.findById(id);

        ordenCompraExistente.setPedido(ordenCompraDetails.getPedido());
        ordenCompraExistente.setFechaOrden(ordenCompraDetails.getFechaOrden()); // Ojo acá, ¿la fecha de orden se puede cambiar después de creada?
        ordenCompraExistente.setMontoTotal(ordenCompraDetails.getMontoTotal()); // El monto total, ¿lo recalculamos o confiamos en el que viene?
        ordenCompraExistente.setMedioPago(ordenCompraDetails.getMedioPago());
        // Si los detalles de la orden se manejan desde acá, también habría que actualizarlos.
        // ordenCompraExistente.setDetalles(ordenCompraDetails.getDetalles());

        // De nuevo, si recalculamos el monto, sería algo así.
        // ordenCompraExistente.calcularMontoTotal(); 
        return super.save(ordenCompraExistente);
    }

    // El delete() ya lo tenemos de BaseServiceImpl y debería andar bien si no hay cosas raras que hacer al borrar.
}