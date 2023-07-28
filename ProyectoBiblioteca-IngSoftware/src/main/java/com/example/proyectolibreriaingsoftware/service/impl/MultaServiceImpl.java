package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Multa;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.repository.IMultaRepo;
import com.example.proyectolibreriaingsoftware.service.IMultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MultaServiceImpl extends CRUDImpl<Multa, Integer> implements IMultaService {

    private final IMultaRepo repo;

    @Override
    protected IGenericRepo<Multa, Integer> getRepo() {
        return repo;
    }
}