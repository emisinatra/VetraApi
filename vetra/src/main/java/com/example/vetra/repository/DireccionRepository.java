package com.example.vetra.repository;

import com.example.vetra.entities.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}