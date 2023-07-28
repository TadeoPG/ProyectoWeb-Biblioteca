package com.example.proyectolibreriaingsoftware.model.llavescompuestas;

import com.example.proyectolibreriaingsoftware.model.Autor;
import com.example.proyectolibreriaingsoftware.model.Prestamo;
import com.example.proyectolibreriaingsoftware.model.Publicacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(PubAutorPK.class)
public class PubAutor {

    @Id
    //Acá directamente no se hace la relación con la publicación, sino en el PubAutorPK
    private Publicacion publicacion;

    @Id
    private Autor autor;

}