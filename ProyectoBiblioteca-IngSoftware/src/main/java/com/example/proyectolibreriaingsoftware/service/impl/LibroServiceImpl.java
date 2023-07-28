package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.Libro;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.repository.ILibroRepo;
import com.example.proyectolibreriaingsoftware.service.ILibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl extends CRUDImpl<Libro, Integer> implements ILibroService {

    private final ILibroRepo repo;

    @Override
    protected IGenericRepo<Libro, Integer> getRepo() {
        return repo;
    }
}