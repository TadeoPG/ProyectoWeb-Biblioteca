package com.example.proyectolibreriaingsoftware.controller;

import com.example.proyectolibreriaingsoftware.dto.CuentaDTO;
import com.example.proyectolibreriaingsoftware.model.Cuenta;
import com.example.proyectolibreriaingsoftware.service.ICuentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CuentaController.class)
public class CuentaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICuentaService service;

    @MockBean(name = "cuentaMapper")
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;


    Cuenta cuenta1 = new Cuenta(1, "tadeo123", "12345", true);
    Cuenta cuenta2 = new Cuenta(2, "rodrigo2322", "12345", true);
    Cuenta cuenta3 = new Cuenta(3, "julitogaray24", "12345678910", true);


    CuentaDTO cuentaDTO1 = new CuentaDTO(1, "tadeo123", "12345", true);
    CuentaDTO cuentaDTO2 = new CuentaDTO(2, "rodrigo2322", "12345", true);
    CuentaDTO cuentaDTO3 = new CuentaDTO(3, "julitogaray24", "12345678910", true);

    @Test
    public void readAllTest() throws Exception {

        List<Cuenta> cuentas = Arrays.asList(cuenta1, cuenta2, cuenta3);
        Mockito.when(service.readAll()).thenReturn(cuentas);
        Mockito.when(modelMapper.map(cuenta1, CuentaDTO.class)).thenReturn(cuentaDTO1);
        Mockito.when(modelMapper.map(cuenta2, CuentaDTO.class)).thenReturn(cuentaDTO2);
        Mockito.when(modelMapper.map(cuenta3, CuentaDTO.class)).thenReturn(cuentaDTO3);


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/cuentas")
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].usuario", is("tadeo123")));
    }

    @Test
    public void readByIdTest() throws Exception{
        int ID = 1;

        Mockito.when(service.readById(any())).thenReturn(cuenta1);
        Mockito.when(modelMapper.map(cuenta1, CuentaDTO.class)).thenReturn(cuentaDTO1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/cuentas/" + ID)
                        .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.usuario", is("tadeo123")));
    }

    @Test
    public void createTest() throws Exception {
        Mockito.when(service.save(any())).thenReturn(cuenta3);
        Mockito.when(modelMapper.map(cuenta3, CuentaDTO.class)).thenReturn(cuentaDTO3);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/cuentas")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(cuentaDTO3));

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated());
//                .andExpect(jsonPath("$.usuario", is("julitogaray24")))
//                .andExpect(jsonPath("$.contrasenia", is("12345678910")))
//                .andExpect(jsonPath("$.enabled", is(true)));
    }
}
