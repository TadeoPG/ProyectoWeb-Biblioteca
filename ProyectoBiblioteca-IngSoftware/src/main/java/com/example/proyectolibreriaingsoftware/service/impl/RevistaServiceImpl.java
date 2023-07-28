package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Revista;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.repository.IRevistaRepo;
import com.example.proyectolibreriaingsoftware.service.IRevistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RevistaServiceImpl extends CRUDImpl<Revista, Integer> implements IRevistaService {

    private final IRevistaRepo repo;

    @Override
    protected IGenericRepo<Revista, Integer> getRepo() {
        return repo;
    }
}