package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Prestamo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.repository.IPrestamoRepo;
import com.example.proyectolibreriaingsoftware.service.IPrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl extends CRUDImpl<Prestamo, Integer> implements IPrestamoService {

    private final IPrestamoRepo repo;

    @Override
    protected IGenericRepo<Prestamo, Integer> getRepo() {
        return repo;
    }
}