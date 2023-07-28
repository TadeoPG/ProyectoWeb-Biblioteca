package com.example.proyectolibreriaingsoftware.model.llavescompuestas;

import com.example.proyectolibreriaingsoftware.model.PalabrasClave;
import com.example.proyectolibreriaingsoftware.model.Publicacion;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(PubPCPK.class)
public class PubPC {

    @Id
    //Acá directamente no se hace la relación con la publicación, sino en el PubAutorPK
    private Publicacion publicacion;

    @Id
    private PalabrasClave palabrasClave;
}