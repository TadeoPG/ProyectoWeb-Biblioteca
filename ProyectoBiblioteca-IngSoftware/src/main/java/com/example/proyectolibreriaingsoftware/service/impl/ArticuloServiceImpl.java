package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Articulo;
import com.example.proyectolibreriaingsoftware.repository.IArticuloRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.IArticuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticuloServiceImpl extends CRUDImpl<Articulo, Integer> implements IArticuloService {

    private final IArticuloRepo repo;

    @Override
    protected IGenericRepo<Articulo, Integer> getRepo() {
        return repo;
    }
}