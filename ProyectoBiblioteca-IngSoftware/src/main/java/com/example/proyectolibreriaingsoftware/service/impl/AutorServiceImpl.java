package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Autor;
import com.example.proyectolibreriaingsoftware.repository.IAutorRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.IAutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl extends CRUDImpl<Autor, Integer> implements IAutorService {

    private final IAutorRepo repo;

    @Override
    protected IGenericRepo<Autor, Integer> getRepo() {
        return repo;
    }
}