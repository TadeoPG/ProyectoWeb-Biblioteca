package com.example.proyectolibreriaingsoftware.service;

import com.example.proyectolibreriaingsoftware.model.Cuenta;

public interface ICuentaService extends ICRUD<Cuenta, Integer> {

    Boolean validarCredenciales(Cuenta cuenta) throws Exception;
}
