package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.RevistaDTO;
import com.example.proyectolibreriaingsoftware.model.Revista;
import com.example.proyectolibreriaingsoftware.service.IRevistaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/revistas")
@RequiredArgsConstructor
public class RevistaController {

    private final IRevistaService service;

    @Qualifier("revistaMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<RevistaDTO>> readAll() throws Exception {
        List<RevistaDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevistaDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Revista obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<RevistaDTO> create(@Valid @RequestBody RevistaDTO dto) throws Exception {
        Revista obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevistaDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody RevistaDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Revista: {

         ...todos los atributos del revista
         Pero como no le pusimos en el RevistaDTO un @NotNull al id ya que se supone que cuando creamos un Revista el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdPublicacion(id);
        Revista obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private RevistaDTO convertToDto(Revista entidad) {
        return mapper.map(entidad, RevistaDTO.class);
    }

    private Revista convertToEntity(RevistaDTO dto) {
        return mapper.map(dto, Revista.class);
    }

}