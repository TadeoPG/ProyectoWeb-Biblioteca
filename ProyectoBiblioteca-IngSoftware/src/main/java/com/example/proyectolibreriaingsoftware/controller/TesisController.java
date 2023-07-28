package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.TesisDTO;
import com.example.proyectolibreriaingsoftware.model.Tesis;
import com.example.proyectolibreriaingsoftware.service.ITesisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/tesis")
@RequiredArgsConstructor
public class TesisController {

    private final ITesisService service;

    @Qualifier("tesisMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<TesisDTO>> readAll() throws Exception {
        List<TesisDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TesisDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Tesis obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<TesisDTO> create(@Valid @RequestBody TesisDTO dto) throws Exception {
        Tesis obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TesisDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody TesisDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Tesis: {

         ...todos los atributos del articulo
         Pero como no le pusimos en el TesisDTO un @NotNull al id ya que se supone que cuando creamos un Tesis el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdPublicacion(id);
        Tesis obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private TesisDTO convertToDto(Tesis entidad) {
        return mapper.map(entidad, TesisDTO.class);
    }

    private Tesis convertToEntity(TesisDTO dto) {
        return mapper.map(dto, Tesis.class);
    }

}