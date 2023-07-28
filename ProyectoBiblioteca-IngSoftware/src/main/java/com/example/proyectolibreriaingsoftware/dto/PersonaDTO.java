package com.example.proyectolibreriaingsoftware.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class PersonaDTO {

    private Integer idPersona;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 20)
    private String nombre;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 20)
    private String apellidos;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[0-9]+")
    private String telefono;

    @NotEmpty
    @Size(min = 8, max = 8)
    private String dni;
}