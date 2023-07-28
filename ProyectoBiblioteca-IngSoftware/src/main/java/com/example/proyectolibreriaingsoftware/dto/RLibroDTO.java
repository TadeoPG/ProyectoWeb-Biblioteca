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
public class RLibroDTO extends PublicacionDTO {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 70)
    private String isbn;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 2000)
    private String sinopsis;

    @NotNull
    private Integer numEdicion;

    @NotNull
    @JsonManagedReference
    private List<PubAutorDTO> autores;

}
