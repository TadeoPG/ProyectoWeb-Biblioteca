package com.example.proyectolibreriaingsoftware.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublicacionDTO {

    private Integer idPublicacion;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String titulo;

    @NotNull
    private Integer numPaginas;

    private LocalDateTime fechaPublicacion;

    private boolean disponibilidad;

    //TOMAR EN CUENTA QUE
    //EL MODEL MAPPER NO MAPEA BIEN SI SE LE DA UN
    //DTO          ENTIDAD
    //nEstante     nEstante
    //Tienen el mismo nombre pero como empieza con el DTO empieza con una sola letra en minúscula hace que falle el mapper
    //SOLUCIÓN: Pasarlo de nEstante a numEstante
    @NotNull
    private Integer numEstante;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String disciplina;

    @NotEmpty
    @Size(min = 3, max = 200)
    private String bibliografia;

    @NotNull
    @JsonManagedReference
    private List<PubAutorDTO> pubAutor;

    @NotNull
    private EditorialDTO editorial;

    @NotNull
    private CategoriaLCDTO categoriaLC;

    @NotNull
    @JsonManagedReference
    private List<PubPCDTO> pubPC;

    private boolean enabled;

}
