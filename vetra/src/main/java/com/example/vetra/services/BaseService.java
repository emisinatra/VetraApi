package com.example.vetra.services;

import com.example.vetra.entities.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity, ID extends Serializable> {
    List<E> findAll() throws Exception;
    Page<E> findAll(Pageable pageable) throws Exception;
    E findById(ID id) throws Exception;
    E save(E entity) throws Exception;
    E update(ID id, E entity) throws Exception;
    boolean delete(ID id) throws Exception;
} 