package com.example.proyectolibreriaingsoftware.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
public class Libro extends Publicacion {

    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 70)
    private String isbn;

    @Column(nullable = false, length = 2000)
    private String sinopsis;

    @Column(nullable = false)
    private Integer numEdicion;

}