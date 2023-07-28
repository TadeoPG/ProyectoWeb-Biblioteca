package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.EspecialidadDTO;
import com.example.proyectolibreriaingsoftware.model.Especialidad;
import com.example.proyectolibreriaingsoftware.service.IEspecialidadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadController {

    private final IEspecialidadService service;

    @Qualifier("especialidadMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EspecialidadDTO>> readAll() throws Exception {
        List<EspecialidadDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Especialidad obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<EspecialidadDTO> create(@Valid @RequestBody EspecialidadDTO dto) throws Exception {
        Especialidad obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody EspecialidadDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Especialidad: {

         ...todos los atributos del especialidad
         Pero como no le pusimos en el EspecialidadDTO un @NotNull al id ya que se supone que cuando creamos un Especialidad el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdEspecialidad(id);
        Especialidad obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private EspecialidadDTO convertToDto(Especialidad entidad) {
        return mapper.map(entidad, EspecialidadDTO.class);
    }

    private Especialidad convertToEntity(EspecialidadDTO dto) {
        return mapper.map(dto, Especialidad.class);
    }

}