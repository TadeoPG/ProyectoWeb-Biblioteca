package com.example.proyectolibreriaingsoftware.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
public class Revista extends Publicacion {

    @Column(nullable = false, length = 25)
    private String issn;

    @Column(nullable = false, length = 10)
    private String factorImpacto;

    @Column(nullable = false)
    private Integer volumen;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, length = 30)
    private String indicadorCalidad;

    @OneToMany(mappedBy = "revista", cascade = CascadeType.ALL)
    private List<Articulo> articulos;

    @OneToMany(mappedBy = "revista", cascade = CascadeType.ALL)
    private List<MiembroComite> miembros;
}