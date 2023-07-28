package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.EmpleadoDTO;
import com.example.proyectolibreriaingsoftware.model.Empleado;
import com.example.proyectolibreriaingsoftware.service.IEmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final IEmpleadoService service;

    @Qualifier("empleadoMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> readAll() throws Exception {
        List<EmpleadoDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Empleado obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> create(@Valid @RequestBody EmpleadoDTO dto) throws Exception {
        Empleado obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody EmpleadoDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Empleado: {

         ...todos los atributos del empleado
         Pero como no le pusimos en el EmpleadoDTO un @NotNull al id ya que se supone que cuando creamos un Empleado el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdPersona(id);
        Empleado obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private EmpleadoDTO convertToDto(Empleado entidad) {
        return mapper.map(entidad, EmpleadoDTO.class);
    }

    private Empleado convertToEntity(EmpleadoDTO dto) {
        return mapper.map(dto, Empleado.class);
    }

}