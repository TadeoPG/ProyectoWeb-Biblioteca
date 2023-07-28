package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.DniDTO;
import com.example.proyectolibreriaingsoftware.dto.UsuarioDTO;
import com.example.proyectolibreriaingsoftware.model.Usuario;
import com.example.proyectolibreriaingsoftware.service.IDniValidationService;
import com.example.proyectolibreriaingsoftware.service.IUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final IUsuarioService service;

    private final IDniValidationService dniService;

    @Qualifier("usuarioMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> readAll() throws Exception {
        List<UsuarioDTO> lista = service.readAll().stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(lista, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Usuario obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto) throws Exception {
        DniDTO dniDTO = dniService.getInfo(dto.getDni());
        Usuario obj = service.save(convertToEntity(dto));

        return new ResponseEntity<>(convertToDto(obj), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(
            @Valid @PathVariable("id") Integer id,
            @RequestBody UsuarioDTO dto) throws Exception {
        /*
        Setea el id del dto que usaremos
        Ejemplo, en el requestBody iría así:
        {
        Usuario: {

         ...todos los atributos del usuario
         Pero como no le pusimos en el UsuarioDTO un @NotNull al id ya que se supone que cuando creamos un Usuario el id es autoincrementable, entonces---
         a nuestro dto que armemos aquí (requestBody) carecerá de un ID.
        }
        }
        Por esa razón tenemos la obligación de hacer el set
         */
        dto.setIdPersona(id);
        Usuario obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    private UsuarioDTO convertToDto(Usuario entidad) {
        return mapper.map(entidad, UsuarioDTO.class);
    }

    private Usuario convertToEntity(UsuarioDTO dto) {
        return mapper.map(dto, Usuario.class);
    }

}