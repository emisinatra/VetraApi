package com.example.vetra.services.Impl;

import com.example.vetra.entities.Talle;
import com.example.vetra.repositories.TalleRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.TalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class TalleServiceImpl extends BaseServiceImpl<Talle, Long> implements TalleService {

    @Autowired
    public TalleServiceImpl(TalleRepository talleRepository) {
        super(talleRepository);
    }

    // Acordate que los métodos CRUD básicos (save, find, update, delete) ya los trae BaseServiceImpl.
    // Si no queremos que se puedan modificar los talles, acá podemos pisar el update así:
    /*
    @Override
    @Transactional
    public Talle update(Long id, Talle entity) throws Exception {
        throw new UnsupportedOperationException("La actualización de Talle no está permitida.");
    }
    */
}
