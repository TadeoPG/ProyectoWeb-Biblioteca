package com.example.proyectolibreriaingsoftware.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
public class Usuario extends Persona {

    @Column(nullable = false, length = 60)
    private String correo;

    @Column(nullable = false, length = 60)
    private String ocupacion;

    @Column(nullable = false)
    private boolean enabled;
}