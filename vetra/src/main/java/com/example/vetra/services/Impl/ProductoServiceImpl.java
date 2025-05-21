package com.example.vetra.services.Impl;

import com.example.vetra.entities.Producto;
import com.example.vetra.repositories.ProductoRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.ProductoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService {

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        super(productoRepository);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) throws Exception {
        validateProducto(producto);
        return super.save(producto);
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto producto) throws Exception {
        super.findById(id);
        
        validateProducto(producto);
        producto.setId(id);
        return super.save(producto);
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        return super.delete(id);
    }

    private void validateProducto(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        
        if (producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        
        if (producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        
        if (producto.getCategorias() == null || producto.getCategorias().isEmpty()) {
            throw new IllegalArgumentException("El producto debe tener al menos una categoría");
        }
        
        if (producto.getTalles() == null || producto.getTalles().isEmpty()) {
            throw new IllegalArgumentException("El producto debe tener al menos un talle");
        }
    }
}