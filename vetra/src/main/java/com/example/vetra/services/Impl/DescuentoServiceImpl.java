package com.example.vetra.services.Impl;

import com.example.vetra.entities.Descuento;
import com.example.vetra.repositories.DescuentoRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DescuentoServiceImpl extends BaseServiceImpl<Descuento, Long> implements DescuentoService {

    @Autowired
    public DescuentoServiceImpl(DescuentoRepository descuentoRepository) {
        super(descuentoRepository);
    }

    @Override
    @Transactional
    public Descuento update(Long id, Descuento descuentoDetails) throws Exception {
        Descuento descuentoExistente = super.findById(id);

        descuentoExistente.setFechaInicio(descuentoDetails.getFechaInicio());
        descuentoExistente.setFechaCierre(descuentoDetails.getFechaCierre());
        descuentoExistente.setDescuento(descuentoDetails.getDescuento());
        
        return super.save(descuentoExistente);
    }
}