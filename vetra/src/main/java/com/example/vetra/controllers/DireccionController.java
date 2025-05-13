package com.example.vetra.controllers;

import com.example.vetra.entities.Direccion;
import com.example.vetra.services.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
//Esto permite que el front pueda hacer request, si no estuviera, al hacer una request lanzaria CORS error.
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class DireccionController {

    private final DireccionService direccionService;

    @PostMapping
    public ResponseEntity<Direccion> create(@RequestBody Direccion direccion) {
        Direccion nuevaDireccion = direccionService.save(direccion);
        return new ResponseEntity<>(nuevaDireccion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Direccion>> getAll() {
        List<Direccion> direcciones = direccionService.findAll();
        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> getById(@PathVariable Long id) {
        return direccionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> update(@PathVariable Long id, @RequestBody Direccion direccion) {
        try {
            Direccion direccionActualizada = direccionService.update(id, direccion);
            return ResponseEntity.ok(direccionActualizada);
        } catch (RuntimeException e) { // Idealmente EntityNotFoundException
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            direccionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) { // Idealmente EntityNotFoundException
            return ResponseEntity.notFound().build();
        }
    }
}
