package com.example.vetra.controllers;

import com.example.vetra.entities.OrdenCompra;
import com.example.vetra.services.OrdenCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-compra")
//Esto permite que el front pueda hacer request, si no estuviera, al hacer una request lanzaria CORS error.
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    @GetMapping
    public ResponseEntity<List<OrdenCompra>> getAll() {
        return ResponseEntity.ok(ordenCompraService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompra> getById(@PathVariable Long id) {
        return ordenCompraService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrdenCompra> create(@RequestBody OrdenCompra ordenCompra) {
        return ResponseEntity.ok(ordenCompraService.save(ordenCompra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenCompra> update(@PathVariable Long id, @RequestBody OrdenCompra ordenCompra) {
        return ResponseEntity.ok(ordenCompraService.update(id, ordenCompra));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ordenCompraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}