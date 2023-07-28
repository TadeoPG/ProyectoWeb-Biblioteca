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
public class RevistaDTO extends PublicacionDTO {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 25)
    private String issn;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 10)
    private String factorImpacto;

    @NotNull
    private Integer volumen;

    @NotNull
    private Integer numero;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30)
    private String indicadorCalidad;

    @JsonManagedReference
    private List<ArticuloDTO> articulos;

    @JsonManagedReference
    private List<MiembroComiteDTO> miembros;
}