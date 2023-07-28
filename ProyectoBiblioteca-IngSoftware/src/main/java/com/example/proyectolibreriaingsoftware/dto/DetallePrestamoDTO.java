package com.example.proyectolibreriaingsoftware.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetallePrestamoDTO {

    private Integer idDetalle;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String estado;

    @Max(value = 30)
    private Integer diasPrestamo;

    @NotNull
    private MultaDTO multa;

    private TesisDTO tesis;

    private RevistaDTO revista;

    private LibroDTO libro;

    //    @NotNull
    @JsonBackReference
    private PrestamoDTO prestamo;
}