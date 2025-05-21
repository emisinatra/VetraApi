package com.example.vetra.controllers;

import com.example.vetra.entities.Producto;
import com.example.vetra.services.Impl.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Controlador para manejar los productos de la tienda
@RestController
@RequestMapping("/api/productos")
//Esto permite que el front pueda hacer request, si no estuviera, al hacer una request lanzaria CORS error.
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {

    // Servicio que maneja toda la lógica de productos
    // private final ProductoService productoService;

    // Constructor que Spring usa para inyectar el servicio
    @Autowired
    public ProductoController(ProductoServiceImpl productoService) {
        super(productoService);
    }

    // Acordate que los endpoints CRUD ya vienen de arriba, del BaseControllerImpl.
    // POST /api/productos - Agrega un producto nuevo
    // GET /api/productos - Trae todos los productos
    // GET /api/productos/{id} - Trae un producto por su ID
    // PUT /api/productos/{id} - Actualiza un producto existente
    // DELETE /api/productos/{id} - Borra un producto
}