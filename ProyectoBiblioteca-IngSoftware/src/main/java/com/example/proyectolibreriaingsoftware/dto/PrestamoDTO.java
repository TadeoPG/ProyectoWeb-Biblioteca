package com.example.proyectolibreriaingsoftware.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class PrestamoDTO {

    private Integer idPrestamo;

    @NotNull
    @NotEmpty
    private LocalDateTime fecha;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 10)
    private String tipo;

    @NotNull
    private EmpleadoDTO empleado;

    @NotNull
    private UsuarioDTO usuario;

    @NotNull
    @JsonManagedReference
    private List<DetallePrestamoDTO> detalles;
}