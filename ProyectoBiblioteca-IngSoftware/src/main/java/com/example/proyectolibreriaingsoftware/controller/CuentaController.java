package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.CuentaDTO;
import com.example.proyectolibreriaingsoftware.model.Cuenta;
import com.example.proyectolibreriaingsoftware.service.ICuentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final ICuentaService service;

    @Qualifier("cuentaMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CuentaDTO>> readAll() throws Exception {
        List<CuentaDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Cuenta obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<CuentaDTO> create(@Valid @RequestBody CuentaDTO dto) throws Exception {
        Cuenta obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody CuentaDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Cuenta: {

         ...todos los atributos del cuenta
         Pero como no le pusimos en el CuentaDTO un @NotNull al id ya que se supone que cuando creamos un Cuenta el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setId(id);
        Cuenta obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @PostMapping("/validar")
    public ResponseEntity<Boolean> validarCredenciales(@RequestBody CuentaDTO dto) throws Exception {
        boolean resultado = service.validarCredenciales(convertToEntity(dto));

        if (resultado) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
    }

    private CuentaDTO convertToDto(Cuenta entidad) {
        return mapper.map(entidad, CuentaDTO.class);
    }

    private Cuenta convertToEntity(CuentaDTO dto) {
        return mapper.map(dto, Cuenta.class);
    }

}