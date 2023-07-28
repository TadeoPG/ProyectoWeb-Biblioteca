package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.CategoriaLCDTO;
import com.example.proyectolibreriaingsoftware.model.CategoriaLC;
import com.example.proyectolibreriaingsoftware.service.ICategoriaLCService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/categoriaLCs")
@RequiredArgsConstructor
public class CategoriaLCController {

    private final ICategoriaLCService service;

    @Qualifier("categoriaLCMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CategoriaLCDTO>> readAll() throws Exception {
        List<CategoriaLCDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaLCDTO> readById(@PathVariable("id") Integer id) throws Exception {
        CategoriaLC obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<CategoriaLCDTO> create(@Valid @RequestBody CategoriaLCDTO dto) throws Exception {
        CategoriaLC obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaLCDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody CategoriaLCDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        CategoriaLC: {

         ...todos los atributos del categoriaLC
         Pero como no le pusimos en el CategoriaLCDTO un @NotNull al id ya que se supone que cuando creamos un CategoriaLC el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdCategoria(id);
        CategoriaLC obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private CategoriaLCDTO convertToDto(CategoriaLC entidad) {
        return mapper.map(entidad, CategoriaLCDTO.class);
    }

    private CategoriaLC convertToEntity(CategoriaLCDTO dto) {
        return mapper.map(dto, CategoriaLC.class);
    }

}