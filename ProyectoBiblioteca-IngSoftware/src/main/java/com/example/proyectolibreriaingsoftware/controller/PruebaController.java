package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.DniDTO;
import com.example.proyectolibreriaingsoftware.service.IDniValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PruebaController {

    private final IDniValidationService service;

    @GetMapping("/validacion")
    public ResponseEntity<DniDTO> validarDni(@RequestParam(name = "dni") String dni) throws Exception {
        DniDTO dto = service.getInfo(dni);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
