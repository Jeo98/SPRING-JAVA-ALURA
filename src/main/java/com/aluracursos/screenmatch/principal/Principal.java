package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    Scanner lectura = new Scanner(System.in);
    private final String API_KEY= "&apikey=8eb50e5";
    private final String API_URL ="http://www.omdbapi.com/?t=";
    ConvierteDatos conversor = new ConvierteDatos();
    ConsumoAPI consumoAPI = new ConsumoAPI();

    public void muestraMenu(){
        int salida=0;
        /*while(salida==0) {
        System.out.println("Ingresar nombre de la serie: ");
        String nombreSerie = lectura.nextLine();

        System.out.println("Ingresar numero de temporada: ");
        int numtemporada = lectura.nextInt();
        System.out.println("Ingrese numero de episodio: ");
        int numeroepisodio = lectura.nextInt();
        String json = consumoAPI.obtenerDatos(API_URL+nombreSerie.replace(" ", "+") + "&Season=" + numtemporada + "&episode=" + numeroepisodio + API_KEY);
        DatosSerie datosSerie = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datosSerie);
        System.out.print("0--> Continuar\n99--> SALIR\n-> ");
        salida = lectura.nextInt();
        lectura.nextLine();
        } //fin while */

        System.out.println("Ingresar nombre de la serie: ");
        String nombreSerie = lectura.nextLine();
        String json2=consumoAPI.obtenerDatos(API_URL+nombreSerie.replace(" ", "+")+"&Season="+ API_KEY);

        DatosSerie datos= conversor.obtenerDatos(json2, DatosSerie.class);
        System.out.println(datos);
        List<DatosTemporada> temporadas =new ArrayList<>();
        for(int i=1; i<= datos.totalTemporadas();i++) {
            json2 = consumoAPI.obtenerDatos(API_URL + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            DatosTemporada datosTemporada = conversor.obtenerDatos(json2, DatosTemporada.class);
            //convierto el json a datostemporada y luego esa información la cargo dentro de la lista
            temporadas.add(datosTemporada);
        }
       // temporadas.forEach(System.out::println);
        //Implementar for multinivel
        /*for(int i=0; i< datos.totalTemporadas();i++){
            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
            for(int j=0; j<episodiosTemporadas.size();j++){
                System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }*/

        //Implementar for multinivel utilizando lambdas

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo()))); //esto es equivalente a for multinivel

    }



}
