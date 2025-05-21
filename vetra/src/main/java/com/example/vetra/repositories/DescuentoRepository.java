package com.example.vetra.repositories;

import com.example.vetra.entities.Descuento;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoRepository extends BaseRepository<Descuento, Long> { 
}