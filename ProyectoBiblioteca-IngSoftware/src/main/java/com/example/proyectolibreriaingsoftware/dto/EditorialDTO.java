package com.example.proyectolibreriaingsoftware.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditorialDTO {

    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 40)
    private String nombre;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[0-9]+")
    private String telefono;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String direccion;

    @NotNull
    @NotEmpty
    @Email
    @Size(max = 50)
    private String correo;

    private boolean enabled;
}
