package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.ArticuloDTO;
import com.example.proyectolibreriaingsoftware.model.Articulo;
import com.example.proyectolibreriaingsoftware.service.IArticuloService;
import com.sun.jdi.VoidValue;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/articulos")
@RequiredArgsConstructor
public class ArticuloController {

    private final IArticuloService service;

    @Qualifier("articuloMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ArticuloDTO>> readAll() throws Exception {
        List<ArticuloDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Articulo obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<ArticuloDTO> create(@Valid @RequestBody ArticuloDTO dto) throws Exception {
        Articulo obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticuloDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody ArticuloDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Articulo: {

         ...todos los atributos del articulo
         Pero como no le pusimos en el ArticuloDTO un @NotNull al id ya que se supone que cuando creamos un Articulo el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdPublicacion(id);
        Articulo obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private ArticuloDTO convertToDto(Articulo entidad) {
        return mapper.map(entidad, ArticuloDTO.class);
    }

    private Articulo convertToEntity(ArticuloDTO dto) {
        return mapper.map(dto, Articulo.class);
    }

}