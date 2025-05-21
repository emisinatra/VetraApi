package com.example.vetra.services.Impl;

import com.example.vetra.entities.PedidoItem;
import com.example.vetra.repositories.PedidoItemRepository;
import com.example.vetra.services.BaseServiceImpl;
import com.example.vetra.services.PedidoItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoItemServiceImpl extends BaseServiceImpl<PedidoItem, Long> implements PedidoItemService {

    @Autowired
    public PedidoItemServiceImpl(PedidoItemRepository pedidoItemRepository) {
        super(pedidoItemRepository);
    }

    @Override
    @Transactional
    public PedidoItem update(Long id, PedidoItem pedidoItemDetails) throws Exception {
        PedidoItem pedidoItemExistente = super.findById(id);
        
        pedidoItemExistente.setCantidad(pedidoItemDetails.getCantidad()); 
        
        return super.save(pedidoItemExistente);
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        return super.delete(id);
    }
} 