package com.example.proyectolibreriaingsoftware.model.llavescompuestas;

import com.example.proyectolibreriaingsoftware.model.Autor;
import com.example.proyectolibreriaingsoftware.model.Publicacion;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class PubAutorPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_publicacion", nullable = false)
    //Esta relación hace posible mostrarse en el JSON todos los autores de las publicaciones.
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;
}