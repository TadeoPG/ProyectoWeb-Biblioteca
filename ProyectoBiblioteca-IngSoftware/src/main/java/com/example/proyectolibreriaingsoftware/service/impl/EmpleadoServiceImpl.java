package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Empleado;
import com.example.proyectolibreriaingsoftware.repository.IEmpleadoRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl extends CRUDImpl<Empleado, Integer> implements IEmpleadoService {

    private final IEmpleadoRepo repo;

    @Override
    protected IGenericRepo<Empleado, Integer> getRepo() {
        return repo;
    }
}