package com.example.proyectolibreriaingsoftware.repository;

import com.example.proyectolibreriaingsoftware.model.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICuentaRepo extends IGenericRepo<Cuenta, Integer> {

    @Query(value = "SELECT dbo.fn_ValidarUsuario(:usuario, :contraseña)", nativeQuery = true)
    @Transactional
    Boolean validarCredenciales(
            @Param("usuario") String usuario,
            @Param("contraseña") String contrasenia
    );

}
