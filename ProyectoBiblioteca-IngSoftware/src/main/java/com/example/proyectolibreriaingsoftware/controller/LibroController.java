package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.LibroDTO;
import com.example.proyectolibreriaingsoftware.model.Libro;
import com.example.proyectolibreriaingsoftware.service.ILibroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor
public class LibroController {

    private final ILibroService service;

    @Qualifier("libroMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<LibroDTO>> readAll() throws Exception {
        List<LibroDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Libro obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<LibroDTO> create(@Valid @RequestBody LibroDTO dto) throws Exception {
        Libro obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody LibroDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Libro: {

         ...todos los atributos del libro
         Pero como no le pusimos en el LibroDTO un @NotNull al id ya que se supone que cuando creamos un Libro el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdPublicacion(id);
        Libro obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private LibroDTO convertToDto(Libro entidad) {
        return mapper.map(entidad, LibroDTO.class);
    }

    private Libro convertToEntity(LibroDTO dto) {
        return mapper.map(dto, Libro.class);
    }

}