package com.aluracursos.screenmatch.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemplosStreams {

    public void muestraEjemplo(){

        List<String> nombres = Arrays.asList("Brenda","zozo", "luis", "miguel");
        nombres.stream() //stream permite aplicar muchas funciones a una lista en una invocacion
                .sorted() //orden alfabetico de A a Z
                .limit(2) // limita la cantidad de personas que se muestran
                .filter(n -> n.startsWith("l")) // filtra y solo muestra los valores(nombres) que empiecen con l
                .map(n -> n.toUpperCase())
                .forEach(System.out::println); //printea cada uno de los elementos de la lista

    }

}
