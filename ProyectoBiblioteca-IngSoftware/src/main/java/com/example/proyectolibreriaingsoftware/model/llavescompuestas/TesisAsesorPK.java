package com.example.proyectolibreriaingsoftware.model.llavescompuestas;

import com.example.proyectolibreriaingsoftware.model.Asesor;
import com.example.proyectolibreriaingsoftware.model.Tesis;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class TesisAsesorPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_tesis", nullable = false)
    private Tesis tesis;

    @ManyToOne
    @JoinColumn(name = "id_asesor", nullable = false)
    private Asesor asesor;
}
