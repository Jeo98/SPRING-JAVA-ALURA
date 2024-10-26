package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // para que ignore los campos que no mapeamos
public record DatosSerie(@JsonAlias("Title") String titulo, @JsonAlias("totalSeasons") Integer totalDeTemporadas, @JsonAlias("imdbRating") String evaluacion) {

}

/*
* podria utilizar JsonProperty, que sirve tanto para leer como para escribir. JsonAlias solo sirve para leer.
*
* Pero en este caso, como solo necesito leer la información de la API, solo utilizo JsonAlias
*
* */