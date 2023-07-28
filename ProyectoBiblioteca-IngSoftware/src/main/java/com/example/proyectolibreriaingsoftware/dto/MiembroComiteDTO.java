package com.example.proyectolibreriaingsoftware.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MiembroComiteDTO extends PersonaDTO {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 40)
    private String rol;

    @NotNull
    @JsonBackReference
    private RevistaDTO revista;
}