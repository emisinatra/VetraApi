package com.example.vetra.services.Impl;

import com.example.vetra.entities.DetalleOrden;
import com.example.vetra.repositories.DetalleOrdenRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.DetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleOrdenServiceImpl extends BaseServiceImpl<DetalleOrden, Long> implements DetalleOrdenService {

    private final DetalleOrdenRepository detalleOrdenRepository; // Necesitamos este repo a mano para usar el findByOrdenCompraId.

    @Autowired
    public DetalleOrdenServiceImpl(DetalleOrdenRepository detalleOrdenRepository) {
        super(detalleOrdenRepository);
        this.detalleOrdenRepository = detalleOrdenRepository;
    }

    @Override
    @Transactional
    public DetalleOrden save(DetalleOrden detalleOrden) throws Exception {
        // Ojo, acá estaría bueno chequear el stock del producto y actualizarlo.
        // También, asegurarse de que el precio unitario sea el posta del producto en este momento.
        // Por ejemplo, podríamos llamar a algo como: productoService.decrementarStock(...)
        return super.save(detalleOrden);
    }

    // Acordate que findById y findAll ya los tenemos por BaseServiceImpl.

    @Override
    public List<DetalleOrden> findByOrdenCompraId(Long ordenCompraId) throws Exception {
        try {
            return detalleOrdenRepository.findByOrdenCompraId(ordenCompraId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Generalmente, no queremos que los detalles de orden se puedan cambiar o borrar así nomás.
    // Por defecto, se heredan de BaseServiceImpl. Si se necesita un comportamiento específico:
    /*
    @Override
    @Transactional
    public DetalleOrden update(Long id, DetalleOrden entity) throws Exception {
        throw new UnsupportedOperationException("La actualización de DetalleOrden no está permitida.");
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        throw new UnsupportedOperationException("La eliminación de DetalleOrden no está permitida.");
    }
    */
} 