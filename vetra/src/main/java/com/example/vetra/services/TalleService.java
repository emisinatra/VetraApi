package com.example.vetra.services;

import com.example.vetra.entities.Talle;

public interface TalleService extends BaseService<Talle, Long> {
    // Para cositas particulares de los talles que no estén en BaseService, van acá.
    // Acordate que el update ya viene de BaseService.
    // Ojo: si no queremos que los talles se puedan cambiar, hay que pisar el método update en la implementación.
}
