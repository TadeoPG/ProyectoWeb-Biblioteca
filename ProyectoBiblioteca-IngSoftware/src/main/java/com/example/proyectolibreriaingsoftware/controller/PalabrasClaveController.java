package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.PalabrasClaveDTO;
import com.example.proyectolibreriaingsoftware.model.PalabrasClave;
import com.example.proyectolibreriaingsoftware.service.IPalabrasClaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/palabrasClaves")
@RequiredArgsConstructor
public class PalabrasClaveController {

    private final IPalabrasClaveService service;

    @Qualifier("palabrasClaveMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PalabrasClaveDTO>> readAll() throws Exception {
        List<PalabrasClaveDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PalabrasClaveDTO> readById(@PathVariable("id") Integer id) throws Exception {
        PalabrasClave obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<PalabrasClaveDTO> create(@Valid @RequestBody PalabrasClaveDTO dto) throws Exception {
        PalabrasClave obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PalabrasClaveDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody PalabrasClaveDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        PalabrasClave: {

         ...todos los atributos del palabrasClave
         Pero como no le pusimos en el PalabrasClaveDTO un @NotNull al id ya que se supone que cuando creamos un PalabrasClave el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdPalabrasclave(id);
        PalabrasClave obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private PalabrasClaveDTO convertToDto(PalabrasClave entidad) {
        return mapper.map(entidad, PalabrasClaveDTO.class);
    }

    private PalabrasClave convertToEntity(PalabrasClaveDTO dto) {
        return mapper.map(dto, PalabrasClave.class);
    }

}