package com.example.proyectolibreriaingsoftware.service.impl;

import com.example.proyectolibreriaingsoftware.dto.DniDTO;
import com.example.proyectolibreriaingsoftware.exceptions.DniNotFoundException;
import com.example.proyectolibreriaingsoftware.exceptions.ModelNotFoundException;
import com.example.proyectolibreriaingsoftware.model.Asesor;
import com.example.proyectolibreriaingsoftware.repository.IAsesorRepo;
import com.example.proyectolibreriaingsoftware.repository.IGenericRepo;
import com.example.proyectolibreriaingsoftware.service.IAsesorService;
import com.example.proyectolibreriaingsoftware.service.IDniValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DniValidationServiceImpl implements IDniValidationService {

    private final RestTemplate restTemplate;

    @Override
    public DniDTO getInfo(String numeroDni) throws Exception {
        String token = "apis-token-1.aTSI1U7KEuT-6bbbCguH-4Y8TI6KS73N";
//        String url = "https://api.apis.net.pe/v2/reniec/dni?numero=" + numeroDni;
        String url = "https://api.apis.net.pe/v1/dni?numero=" + numeroDni;
        String authorization = "Bearer " + token;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Referer", "https://apis.net.pe/consulta-dni-api");
        headers.set("Authorization", authorization);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<DniDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, DniDTO.class);

        return response.getBody();
    }
}