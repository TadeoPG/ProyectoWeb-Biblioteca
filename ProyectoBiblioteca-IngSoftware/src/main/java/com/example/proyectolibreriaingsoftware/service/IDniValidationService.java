package com.example.proyectolibreriaingsoftware.service;


import com.example.proyectolibreriaingsoftware.dto.DniDTO;
import com.example.proyectolibreriaingsoftware.exceptions.DniNotFoundException;

import java.util.Optional;

public interface IDniValidationService {
    DniDTO getInfo(String numeroDni) throws Exception;
}
