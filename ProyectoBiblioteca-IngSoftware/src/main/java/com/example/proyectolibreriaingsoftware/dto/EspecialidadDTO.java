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
public class EspecialidadDTO {

    private Integer idEspecialidad;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String descripcion;

    private boolean enabled;
}
