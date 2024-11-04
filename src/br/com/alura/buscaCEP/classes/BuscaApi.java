package br.com.alura.buscaCEP.classes;

import br.com.alura.buscaCEP.exececoes.ErroDeBadRequest;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaApi {
    private String link;

    public CepJson consultaApi(String cepDigitado) throws IOException, InterruptedException {
        if (cepDigitado.length() > 8) {
            throw new ErroDeBadRequest("CEP maior que 8 caracteres, informe um CEP válido.");
        } else {
        this.link = "https://viacep.com.br/ws/" + cepDigitado + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.link)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), CepJson.class);
        }
    }
}
