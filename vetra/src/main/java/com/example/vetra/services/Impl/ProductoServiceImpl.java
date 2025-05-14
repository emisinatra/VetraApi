package com.example.vetra.services.Impl;

import com.example.vetra.entities.Producto;
import com.example.vetra.repositories.ProductoRepository;
import com.example.vetra.services.ProductoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    @Transactional
    public Producto save(Producto producto) {
        validateProducto(producto);
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto producto) {
        if (!productoRepository.existsById(id)) {
            throw new EntityNotFoundException("No existe un producto con el ID: " + id);
        }
        
        validateProducto(producto);
        producto.setId(id);
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new EntityNotFoundException("No existe un producto con el ID: " + id);
        }
        productoRepository.deleteById(id);
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
            System.out.println("Categorías recibidas: " + producto.getCategorias());
            throw new IllegalArgumentException("El producto debe tener al menos una categoría");
        }
        
        if (producto.getTalles() == null || producto.getTalles().isEmpty()) {
            throw new IllegalArgumentException("El producto debe tener al menos un talle");
        }
    }
}