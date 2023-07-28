package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.model.MiembroComite;
import com.example.proyectolibreriaingsoftware.model.PalabrasClave;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.repository.IMiembroComiteRepo;
import com.example.proyectolibreriaingsoftware.repository.IPalabrasClaveRepo;
import com.example.proyectolibreriaingsoftware.service.IMiembroComiteService;
import com.example.proyectolibreriaingsoftware.service.IPalabrasClaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MiembroComiteServiceImpl extends CRUDImpl<MiembroComite, Integer> implements IMiembroComiteService {

    private final IMiembroComiteRepo repo;

    @Override
    protected IGenericRepo<MiembroComite, Integer> getRepo() {
        return repo;
    }
}