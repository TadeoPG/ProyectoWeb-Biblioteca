package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.llavescompuestas.PubAutor;
import com.example.proyectolibreriaingsoftware.model.llavescompuestas.PubPC;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.repository.IPubAutorRepo;
import com.example.proyectolibreriaingsoftware.repository.IPubPCRepo;
import com.example.proyectolibreriaingsoftware.service.IPubAutorService;
import com.example.proyectolibreriaingsoftware.service.IPubPCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PubPCService extends CRUDImpl<PubPC, Integer> implements IPubPCService {

    private final IPubPCRepo repo;

    @Override
    protected IGenericRepo<PubPC, Integer> getRepo() {
        return repo;
    }
}