package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.PalabrasClave;
import com.example.proyectolibreriaingsoftware.repository.IPalabrasClaveRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.IPalabrasClaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PalabrasClaveServiceImpl extends CRUDImpl<PalabrasClave, Integer> implements IPalabrasClaveService {

    private final IPalabrasClaveRepo repo;

    @Override
    protected IGenericRepo<PalabrasClave, Integer> getRepo() {
        return repo;
    }
}