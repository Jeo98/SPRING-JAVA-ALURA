package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;


public class ConvierteDatos implements IConvierteDatos{

    private ObjectMapper objectMapper = new ObjectMapper();


    // permite mapear los valores que vienen de la API

   /* public DatosSerie obtenerDatos(String json){
       Cual es el problema aqui... no trabaja de forma generalizada, sino que esta funcion solo
       trabajaria con DatosSerie. Supongamos que luego debo trabajar con DatosActores, tendré que crear
       un metodo DatosActores para poder ver esos datos y asi con más información. Por ello es mejor
       implementar una interface que trabaje con tipos de datos genéricos -->IconvierteDatos
    }*/

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
            //objectMapper va a leer el valor que viene en el json y lo convierte al tipo generico
            //debe estar entre un try-catch por si ocurre error(intellij notifica del error si no está)
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
    }

