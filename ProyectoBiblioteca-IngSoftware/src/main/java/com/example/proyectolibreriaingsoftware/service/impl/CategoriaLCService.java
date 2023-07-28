package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.CategoriaLC;
import com.example.proyectolibreriaingsoftware.repository.ICategoriaLCRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.ICategoriaLCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaLCService extends CRUDImpl<CategoriaLC, Integer> implements ICategoriaLCService {

    private final ICategoriaLCRepo repo;

    @Override
    protected IGenericRepo<CategoriaLC, Integer> getRepo() {
        return repo;
    }
}