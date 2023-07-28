package com.example.proyectolibreriaingsoftware.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
public class Empleado extends Persona {

    @Column(columnDefinition = "money", nullable = false)
    private double sueldo;

    @Column(nullable = false)
    private Integer horasLaborales;

    @Column(nullable = false, length = 30)
    private String tipoContrato;

    @Column(nullable = false, length = 10)
    private String afiliacion;

    @Column(nullable = false, length = 20)
    private String cargo;

    @OneToOne
    @JoinColumn(name = "id_cuenta", nullable = false, foreignKey = @ForeignKey(name = "FK_Empleado_Cuenta"))
    private Cuenta cuenta;

    @Column(nullable = false)
    private boolean enabled;
}
