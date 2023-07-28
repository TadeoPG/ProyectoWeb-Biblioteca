package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.PrestamoDTO;
import com.example.proyectolibreriaingsoftware.model.Prestamo;
import com.example.proyectolibreriaingsoftware.service.IPrestamoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/prestamos")
@RequiredArgsConstructor
public class PrestamoController {

    private final IPrestamoService service;

    @Qualifier("prestamoMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PrestamoDTO>> readAll() throws Exception {
        List<PrestamoDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Prestamo obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<PrestamoDTO> create(@Valid @RequestBody PrestamoDTO dto) throws Exception {
        Prestamo obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestamoDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody PrestamoDTO dto) throws Exception {

        dto.setIdPrestamo(id);
        Prestamo obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private PrestamoDTO convertToDto(Prestamo entidad) {
        return mapper.map(entidad, PrestamoDTO.class);
    }

    private Prestamo convertToEntity(PrestamoDTO dto) {
        return mapper.map(dto, Prestamo.class);
    }

}