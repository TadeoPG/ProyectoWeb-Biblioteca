package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Asesor;
import com.example.proyectolibreriaingsoftware.model.Especialidad;
import com.example.proyectolibreriaingsoftware.repository.IAsesorRepo;
import com.example.proyectolibreriaingsoftware.repository.IEspecialidadRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.IAsesorService;
import com.example.proyectolibreriaingsoftware.service.IEspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadService {

    private final IEspecialidadRepo repo;

    @Override
    protected IGenericRepo<Especialidad, Integer> getRepo() {
        return repo;
    }
}