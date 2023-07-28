package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.PubAutorDTO;
import com.example.proyectolibreriaingsoftware.model.llavescompuestas.PubAutor;
import com.example.proyectolibreriaingsoftware.service.IPubAutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/pubAutors")
@RequiredArgsConstructor
public class PubAutorController {

    private final IPubAutorService service;

    @Qualifier("pubAutorMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PubAutorDTO>> readAll() throws Exception {
        List<PubAutorDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PubAutorDTO> readById(@PathVariable("id") Integer id) throws Exception {
        PubAutor obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<PubAutorDTO> create(@Valid @RequestBody PubAutorDTO dto) throws Exception {
        PubAutor obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PubAutorDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody PubAutorDTO dto) throws Exception {

//        dto.setIdPubAutor(id);
        PubAutor obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private PubAutorDTO convertToDto(PubAutor entidad) {
        return mapper.map(entidad, PubAutorDTO.class);
    }

    private PubAutor convertToEntity(PubAutorDTO dto) {
        return mapper.map(dto, PubAutor.class);
    }

}