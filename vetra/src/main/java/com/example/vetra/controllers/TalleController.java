package com.example.vetra.controllers;

import com.example.vetra.entities.Talle;
import com.example.vetra.services.TalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talles")
@RequiredArgsConstructor
public class TalleController {

    private final TalleService talleService;

    @GetMapping
    public ResponseEntity<List<Talle>> getAll() {
        return ResponseEntity.ok(talleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talle> getById(@PathVariable Long id) {
        return talleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Talle> create(@RequestBody Talle talle) {
        return ResponseEntity.ok(talleService.save(talle));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Talle> update(@PathVariable Long id, @RequestBody Talle talle) {
        if (!talleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        talle.setId(id);
        return ResponseEntity.ok(talleService.save(talle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        talleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
