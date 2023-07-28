package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Articulo;
import com.example.proyectolibreriaingsoftware.model.SubCategoriaLC;
import com.example.proyectolibreriaingsoftware.repository.IArticuloRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.repository.ISubCategoriaLCRepo;
import com.example.proyectolibreriaingsoftware.service.IArticuloService;
import com.example.proyectolibreriaingsoftware.service.ISubCategoriaLCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubCategoriaLCServiceImpl extends CRUDImpl<SubCategoriaLC, Integer> implements ISubCategoriaLCService {

    private final ISubCategoriaLCRepo repo;

    @Override
    protected IGenericRepo<SubCategoriaLC, Integer> getRepo() {
        return repo;
    }
}