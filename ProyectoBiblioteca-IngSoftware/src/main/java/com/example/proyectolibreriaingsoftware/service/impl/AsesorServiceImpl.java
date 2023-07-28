package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Asesor;
import com.example.proyectolibreriaingsoftware.repository.IAsesorRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.IAsesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsesorServiceImpl extends CRUDImpl<Asesor, Integer> implements IAsesorService {

    private final IAsesorRepo repo;

    @Override
    protected IGenericRepo<Asesor, Integer> getRepo() {
        return repo;
    }
}