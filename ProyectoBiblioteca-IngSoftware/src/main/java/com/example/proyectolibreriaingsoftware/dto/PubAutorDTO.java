package com.example.proyectolibreriaingsoftware.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PubAutorDTO {

    @NotNull
    @JsonBackReference
    private PublicacionDTO publicacion;

    @NotNull
    private AutorDTO autor;
}