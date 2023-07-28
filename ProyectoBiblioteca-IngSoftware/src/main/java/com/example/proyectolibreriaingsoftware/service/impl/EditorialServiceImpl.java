package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Editorial;
import com.example.proyectolibreriaingsoftware.repository.IEditorialRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.IEditorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditorialServiceImpl extends CRUDImpl<Editorial, Integer> implements IEditorialService {

    private final IEditorialRepo repo;

    @Override
    protected IGenericRepo<Editorial, Integer> getRepo() {
        return repo;
    }
}