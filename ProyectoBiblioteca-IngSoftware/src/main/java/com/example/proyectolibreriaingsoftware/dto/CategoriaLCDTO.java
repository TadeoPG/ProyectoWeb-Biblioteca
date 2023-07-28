package com.example.proyectolibreriaingsoftware.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class CategoriaLCDTO {

    private Integer idCategoria;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 1)
    private String codigo;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String descripcion;

    @NotNull
    private SubCategoriaLCDTO subCategoriaLC;
}
