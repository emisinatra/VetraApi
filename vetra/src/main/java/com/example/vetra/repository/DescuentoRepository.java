package com.example.vetra.repository;

import com.example.vetra.entities.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescuentoRepository extends JpaRepository<Descuento, Long> {
}