package com.example.proyectolibreriaingsoftware.model;

import com.example.proyectolibreriaingsoftware.model.llavescompuestas.PubPC;
import com.example.proyectolibreriaingsoftware.model.llavescompuestas.TesisAsesor;
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
public class Tesis extends Publicacion {

    @Column(nullable = false, length = 50)
    private String institucion;

    @Column(nullable = false, length = 50)
    private String grado;

    @Column(nullable = false, length = 100)
    private String carreraProfesional;

    @Column(nullable = false, length = 500)
    private String resumen;

    @OneToMany(mappedBy = "tesis", cascade = CascadeType.ALL)
    private List<TesisAsesor> tesisAsesor;
}