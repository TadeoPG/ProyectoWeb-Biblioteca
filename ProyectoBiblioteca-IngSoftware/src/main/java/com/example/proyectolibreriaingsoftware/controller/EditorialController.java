package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.EditorialDTO;
import com.example.proyectolibreriaingsoftware.model.Editorial;
import com.example.proyectolibreriaingsoftware.service.IEditorialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/editoriales")
@RequiredArgsConstructor
public class EditorialController {

    private final IEditorialService service;

    @Qualifier("editorialMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EditorialDTO>> readAll() throws Exception {
        List<EditorialDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorialDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Editorial obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<EditorialDTO> create(@Valid @RequestBody EditorialDTO dto) throws Exception {
        Editorial obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditorialDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody EditorialDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Editorial: {

         ...todos los atributos del editorial
         Pero como no le pusimos en el EditorialDTO un @NotNull al id ya que se supone que cuando creamos un Editorial el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setId(id);
        Editorial obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private EditorialDTO convertToDto(Editorial entidad) {
        return mapper.map(entidad, EditorialDTO.class);
    }

    private Editorial convertToEntity(EditorialDTO dto) {
        return mapper.map(dto, Editorial.class);
    }

}