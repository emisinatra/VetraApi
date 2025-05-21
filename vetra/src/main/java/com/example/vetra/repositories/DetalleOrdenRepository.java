package com.example.vetra.repositories;

import com.example.vetra.entities.DetalleOrden;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleOrdenRepository extends BaseRepository<DetalleOrden, Long> {
    List<DetalleOrden> findByOrdenCompraId(Long ordenCompraId);
} 