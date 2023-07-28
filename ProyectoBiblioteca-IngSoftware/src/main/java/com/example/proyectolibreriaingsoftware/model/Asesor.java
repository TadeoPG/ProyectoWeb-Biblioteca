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
public class Asesor extends Persona {

    @OneToOne
    @JoinColumn(name = "id_especialidad", nullable = false, foreignKey = @ForeignKey(name = "FK_Asesor_Especialidad"))
    private Especialidad especialidad;

    @Column(nullable = false, length = 20)
    private String gradoAcademico;

    @Column(nullable = false, length = 50)
    private String afiliacionInstitucional;

    @Column(nullable = false)
    private boolean enabled;
}
