package com.example.proyectolibreriaingsoftware.model.llavescompuestas;

import com.example.proyectolibreriaingsoftware.model.Asesor;
import com.example.proyectolibreriaingsoftware.model.Tesis;
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
@IdClass(TesisAsesorPK.class)
public class TesisAsesor {

    @Id
    private Tesis tesis;

    @Id
    private Asesor asesor;
}