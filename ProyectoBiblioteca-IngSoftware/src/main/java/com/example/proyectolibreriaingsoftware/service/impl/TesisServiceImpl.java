package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Tesis;
import com.example.proyectolibreriaingsoftware.repository.ITesisRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.ITesisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TesisServiceImpl extends CRUDImpl<Tesis, Integer> implements ITesisService {

    private final ITesisRepo repo;

    @Override
    protected IGenericRepo<Tesis, Integer> getRepo() {
        return repo;
    }
}