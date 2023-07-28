package com.example.proyectolibreriaingsoftware.model.llavescompuestas;

import com.example.proyectolibreriaingsoftware.model.PalabrasClave;
import com.example.proyectolibreriaingsoftware.model.Publicacion;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class PubPCPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_publicacion", nullable = false)
    //Esta relación hace posible mostrarse en el JSON todos los autores de las publicaciones.
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name = "id_palabrasclave", nullable = false)
    private PalabrasClave palabrasClave;
}
