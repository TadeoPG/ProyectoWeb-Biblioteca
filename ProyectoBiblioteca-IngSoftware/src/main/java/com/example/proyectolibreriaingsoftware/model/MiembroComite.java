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
public class MiembroComite extends Persona {

    @Column(nullable = false, length = 40)
    private String rol;

    @ManyToOne
    @JoinColumn(name = "id_revista", nullable = false, foreignKey = @ForeignKey(name = "FK_Miembro_Revista"))
    private Revista revista;
}