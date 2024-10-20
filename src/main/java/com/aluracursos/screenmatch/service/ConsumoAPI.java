package com.aluracursos.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class ConsumoAPI {

    public String obtenerDatos(String URL){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL)).build();
        HttpResponse<String> response = null;

        try{
            response=client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        String json=response.body();

        return json;
    }
}
