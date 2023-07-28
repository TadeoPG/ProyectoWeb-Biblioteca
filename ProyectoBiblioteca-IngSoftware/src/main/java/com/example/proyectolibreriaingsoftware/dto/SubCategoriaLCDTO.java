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
public class SubCategoriaLCDTO {

    private Integer idSubcategoria;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 10)
    private String codigo;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 100)
    private String descripcion;
}
