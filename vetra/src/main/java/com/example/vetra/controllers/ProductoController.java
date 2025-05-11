package com.example.vetra.controllers;

import com.example.vetra.entities.Producto;
import com.example.vetra.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controlador para manejar los productos de la tienda
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    // Servicio que maneja toda la lógica de productos
    private final ProductoService productoService;

    // Constructor que Spring usa para inyectar el servicio
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // POST /api/productos - Agrega un producto nuevo
    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.save(producto));
    }

    // GET /api/productos - Trae todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    // GET /api/productos/{id} - Trae un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Long id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /api/productos/{id} - Actualiza un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.update(id, producto));
    }

    // DELETE /api/productos/{id} - Borra un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}