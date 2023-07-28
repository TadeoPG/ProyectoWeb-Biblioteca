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
public class TesisAsesorDTO {

    @NotNull
    @JsonBackReference
    private TesisDTO tesis;

    @NotNull
    private AsesorDTO asesor;
}
