package com.example.proyectolibreriaingsoftware.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TesisDTO extends PublicacionDTO {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String institucion;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 500)
    private String resumen;

    @NotNull
    @JsonManagedReference
    private List<TesisAsesorDTO> tesisAsesor;
}