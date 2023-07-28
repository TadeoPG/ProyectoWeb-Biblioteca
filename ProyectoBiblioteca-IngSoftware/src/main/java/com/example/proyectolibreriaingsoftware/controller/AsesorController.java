package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.AsesorDTO;
import com.example.proyectolibreriaingsoftware.model.Asesor;
import com.example.proyectolibreriaingsoftware.service.IAsesorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/asesores")
@RequiredArgsConstructor
public class AsesorController {

    private final IAsesorService service;

    @Qualifier("asesorMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<AsesorDTO>> readAll() throws Exception {
        List<AsesorDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsesorDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Asesor obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<AsesorDTO> create(@Valid @RequestBody AsesorDTO dto) throws Exception {
        Asesor obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsesorDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody AsesorDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Asesor: {

         ...todos los atributos del asesor
         Pero como no le pusimos en el AsesorDTO un @NotNull al id ya que se supone que cuando creamos un Asesor el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdPersona(id);
        Asesor obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private AsesorDTO convertToDto(Asesor entidad) {
        return mapper.map(entidad, AsesorDTO.class);
    }

    private Asesor convertToEntity(AsesorDTO dto) {
        return mapper.map(dto, Asesor.class);
    }

}