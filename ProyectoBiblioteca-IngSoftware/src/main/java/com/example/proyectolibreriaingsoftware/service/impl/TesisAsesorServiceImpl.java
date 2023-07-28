package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.llavescompuestas.TesisAsesor;
import com.example.proyectolibreriaingsoftware.repository.ITesisAsesorRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.ITesisAsesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TesisAsesorServiceImpl extends CRUDImpl<TesisAsesor, Integer> implements ITesisAsesorService {

    private final ITesisAsesorRepo repo;

    @Override
    protected IGenericRepo<TesisAsesor, Integer> getRepo() {
        return repo;
    }
}