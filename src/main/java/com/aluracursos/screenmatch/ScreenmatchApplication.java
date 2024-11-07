package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{


	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo, jeo Spring");
		Principal menu= new Principal();
		menu.muestraMenu();

		/*Scanner lectura = new Scanner(System.in);
		var consumoAPI= new ConsumoAPI();
		var json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=8eb50e5");
		System.out.println(json);//muestar tooda la info de la API

		ConvierteDatos conversor = new ConvierteDatos();
		var datos = conversor.obtenerDatos(json, DatosSerie.class);
		/*entonces datos va a tener la conversion del json que trae toda la info de la API
		y por medio del metodo de la interfaz que luego se aplica en la funcion obtenerDatos, los convierte
		en un objeto de la clase DatosSerie, mostrando solamente la info que contienen esa clase RECORD!
		*

		NO OLVIDAR de ignorar las propiedades no mapeadas en el RECORD

		@JsonIgnoreProperties(ignoreUnknown = true) --> para que ignore los campos que no mapeamos
*/


	}
}
