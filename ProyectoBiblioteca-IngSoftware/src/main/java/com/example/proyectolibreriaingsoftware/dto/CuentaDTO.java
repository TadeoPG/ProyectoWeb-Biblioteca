package com.example.proyectolibreriaingsoftware.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CuentaDTO {

    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 30)
    private String usuario;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 40)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String contrasenia;

    private boolean enabled;
}