package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.MiembroComiteDTO;
import com.example.proyectolibreriaingsoftware.model.MiembroComite;
import com.example.proyectolibreriaingsoftware.service.IMiembroComiteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/miembrosComites")
@RequiredArgsConstructor
public class MiembroComiteController {

    private final IMiembroComiteService service;

    @Qualifier("miembroComiteMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<MiembroComiteDTO>> readAll() throws Exception {
        List<MiembroComiteDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiembroComiteDTO> readById(@PathVariable("id") Integer id) throws Exception {
        MiembroComite obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<MiembroComiteDTO> create(@Valid @RequestBody MiembroComiteDTO dto) throws Exception {
        MiembroComite obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MiembroComiteDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody MiembroComiteDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        MiembroComite: {

         ...todos los atributos del prestamo
         Pero como no le pusimos en el MiembroComiteDTO un @NotNull al id ya que se supone que cuando creamos un MiembroComite el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdPersona(id);
        MiembroComite obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private MiembroComiteDTO convertToDto(MiembroComite entidad) {
        return mapper.map(entidad, MiembroComiteDTO.class);
    }

    private MiembroComite convertToEntity(MiembroComiteDTO dto) {
        return mapper.map(dto, MiembroComite.class);
    }

}