package com.example.vetra.repositories;

import com.example.vetra.entities.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long> {
}