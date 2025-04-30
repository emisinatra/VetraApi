package com.example.vetra.services;

import com.example.vetra.entities.Talle;
import java.util.List;
import java.util.Optional;

public interface TalleService {
    List<Talle> findAll();
    Optional<Talle> findById(Long id);
    Talle save(Talle talle);
    void deleteById(Long id);
}
