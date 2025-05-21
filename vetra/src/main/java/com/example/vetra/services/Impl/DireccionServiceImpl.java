package com.example.vetra.services.Impl;

import com.example.vetra.entities.Direccion;
import com.example.vetra.repositories.DireccionRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.DireccionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DireccionServiceImpl extends BaseServiceImpl<Direccion, Long> implements DireccionService {

    @Autowired
    public DireccionServiceImpl(DireccionRepository direccionRepository) {
        super(direccionRepository);
    }

    @Override
    @Transactional
    public Direccion update(Long id, Direccion direccionDetails) throws Exception {
        Direccion direccionExistente = super.findById(id);
        
        direccionExistente.setCalle(direccionDetails.getCalle());
        direccionExistente.setCodpost(direccionDetails.getCodpost());
        // La lista de usuarios no la tocamos desde acá, eso se maneja desde Usuario o con métodos específicos.
        // Por eso, la línea de abajo está comentada:
        // // direccionExistente.setUsuarios(direccionDetails.getUsuarios()); 
        
        return super.save(direccionExistente);
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        return super.delete(id);
    }
}