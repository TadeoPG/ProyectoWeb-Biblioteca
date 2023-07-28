package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.AutorDTO;
import com.example.proyectolibreriaingsoftware.model.Autor;
import com.example.proyectolibreriaingsoftware.service.IAutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {

    private final IAutorService service;

    @Qualifier("autorMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<AutorDTO>> readAll() throws Exception {
        List<AutorDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Autor obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<AutorDTO> create(@Valid @RequestBody AutorDTO dto) throws Exception {
        dto.setEnabled(true);
        Autor obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody AutorDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Autor: {

         ...todos los atributos del autor
         Pero como no le pusimos en el AutorDTO un @NotNull al id ya que se supone que cuando creamos un Autor el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdPersona(id);
        Autor obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private AutorDTO convertToDto(Autor entidad) {
        return mapper.map(entidad, AutorDTO.class);
    }

    private Autor convertToEntity(AutorDTO dto) {
        return mapper.map(dto, Autor.class);
    }

}