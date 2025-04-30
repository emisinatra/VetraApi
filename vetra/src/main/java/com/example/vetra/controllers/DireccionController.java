package com.example.vetra.controllers;

import com.example.vetra.entities.Direccion;
import com.example.vetra.services.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
@RequiredArgsConstructor
public class DireccionController {

    private final DireccionService direccionService;

    @GetMapping
    public List<Direccion> findAll() {
        return direccionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> findById(@PathVariable Long id) {
        return ResponseEntity.of(direccionService.findById(id));
    }

    @PostMapping
    public Direccion create(@RequestBody Direccion direccion) {
        return direccionService.save(direccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> update(@PathVariable Long id, @RequestBody Direccion direccion) {
        return ResponseEntity.of(direccionService.update(id, direccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        direccionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
