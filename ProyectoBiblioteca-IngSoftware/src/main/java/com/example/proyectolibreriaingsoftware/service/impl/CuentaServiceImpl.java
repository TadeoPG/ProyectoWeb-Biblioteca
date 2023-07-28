package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Cuenta;
import com.example.proyectolibreriaingsoftware.repository.ICuentaRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.ICuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CuentaServiceImpl extends CRUDImpl<Cuenta, Integer> implements ICuentaService {

    private final ICuentaRepo repo;

    @Override
    protected IGenericRepo<Cuenta, Integer> getRepo() {
        return repo;
    }

    @Override
    public Boolean validarCredenciales(Cuenta cuenta) throws Exception {
        return repo.validarCredenciales(cuenta.getUsuario(), cuenta.getContrasenia());
    }
}