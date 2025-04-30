package com.example.vetra.controllers;

import com.example.vetra.entities.Descuento;
import com.example.vetra.services.DescuentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/descuentos")
public class DescuentoController {

    private final DescuentoService descuentoService;

    public DescuentoController(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    @PostMapping
    public ResponseEntity<Descuento> create(@RequestBody Descuento descuento) {
        return ResponseEntity.ok(descuentoService.save(descuento));
    }

    @GetMapping
    public ResponseEntity<List<Descuento>> getAll() {
        return ResponseEntity.ok(descuentoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Descuento> getById(@PathVariable Long id) {
        return descuentoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Descuento> update(@PathVariable Long id, @RequestBody Descuento descuento) {
        return ResponseEntity.ok(descuentoService.update(id, descuento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        descuentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}