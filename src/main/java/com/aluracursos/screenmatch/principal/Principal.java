package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {

    Scanner lectura = new Scanner(System.in);


    public void muestraMenu(){
        int salida=0;
        var consumoAPI= new ConsumoAPI();
        var json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=8eb50e5");
        ConvierteDatos conversor = new ConvierteDatos();
        var datos = conversor.obtenerDatos(json, DatosSerie.class);

        while(salida==0) {
            System.out.println("Ingresar numero de temporada: ");
            int numtemporada = lectura.nextInt();
            System.out.println("Ingrese numero de episodio: ");
            int numeroepisodio = lectura.nextInt();
            json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&Season=" + numtemporada + "&episode=" + numeroepisodio + "&apikey=8eb50e5");
            DatosEpisodio datosepisodio = conversor.obtenerDatos(json, DatosEpisodio.class);
            System.out.println(datosepisodio);

            System.out.println("Ingresar 1 para salir, 0 para buscar: ");
            salida = lectura.nextInt();
        }

    }
}
