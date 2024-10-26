package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosTemporada(@JsonAlias("Season") Integer numtemporada,
                             @JsonAlias("Episodes") List<DatosEpisodio> episodios ) {
}
