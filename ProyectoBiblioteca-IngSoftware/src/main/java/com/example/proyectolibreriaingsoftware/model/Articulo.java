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
public class Articulo extends Publicacion {

    @Column(nullable = false, length = 30)
    private String indicadorCitacion;

    @ManyToOne
    @JoinColumn(name = "id_revista", nullable = false, foreignKey = @ForeignKey(name = "FK_Articulo_Revista"))
    private Revista revista;
}