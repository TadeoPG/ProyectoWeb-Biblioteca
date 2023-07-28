package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.SubCategoriaLCDTO;
import com.example.proyectolibreriaingsoftware.model.SubCategoriaLC;
import com.example.proyectolibreriaingsoftware.service.ISubCategoriaLCService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/subCategoriaLCs")
@RequiredArgsConstructor
public class SubCategoriaLCController {

    private final ISubCategoriaLCService service;

    @Qualifier("subcategoriaLCMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<SubCategoriaLCDTO>> readAll() throws Exception {
        List<SubCategoriaLCDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoriaLCDTO> readById(@PathVariable("id") Integer id) throws Exception {
        SubCategoriaLC obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<SubCategoriaLCDTO> create(@Valid @RequestBody SubCategoriaLCDTO dto) throws Exception {
        SubCategoriaLC obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoriaLCDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody SubCategoriaLCDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        SubCategoriaLC: {

         ...todos los atributos del subcategoriaLC
         Pero como no le pusimos en el SubCategoriaLCDTO un @NotNull al id ya que se supone que cuando creamos un SubCategoriaLC el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdSubcategoria(id);
        SubCategoriaLC obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private SubCategoriaLCDTO convertToDto(SubCategoriaLC entidad) {
        return mapper.map(entidad, SubCategoriaLCDTO.class);
    }

    private SubCategoriaLC convertToEntity(SubCategoriaLCDTO dto) {
        return mapper.map(dto, SubCategoriaLC.class);
    }

}