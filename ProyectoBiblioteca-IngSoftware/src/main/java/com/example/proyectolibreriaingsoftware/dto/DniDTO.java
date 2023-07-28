package com.example.proyectolibreriaingsoftware.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DniDTO {

    private String nombres;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String tipoDocumento;

    private String numeroDocumento;

    private String digitoVerificador;
}
