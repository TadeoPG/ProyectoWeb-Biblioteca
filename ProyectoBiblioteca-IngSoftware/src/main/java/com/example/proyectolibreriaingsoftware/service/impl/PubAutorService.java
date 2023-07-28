package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.CategoriaLC;
import com.example.proyectolibreriaingsoftware.model.llavescompuestas.PubAutor;
import com.example.proyectolibreriaingsoftware.repository.ICategoriaLCRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.repository.IPubAutorRepo;
import com.example.proyectolibreriaingsoftware.service.ICategoriaLCService;
import com.example.proyectolibreriaingsoftware.service.IPubAutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PubAutorService extends CRUDImpl<PubAutor, Integer> implements IPubAutorService {

    private final IPubAutorRepo repo;

    @Override
    protected IGenericRepo<PubAutor, Integer> getRepo() {
        return repo;
    }
}