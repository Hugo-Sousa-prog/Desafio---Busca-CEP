package br.com.alura.buscaCEP.classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeraArquivo {

    public void gerarArquivo(List<CepGson> lista) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter("cep.json");
        escrita.write(gson.toJson(lista));
        escrita.close();
    }
}
