package br.com.alura.buscaCEP.classes;

public record CepJson(String cep, String logradouro, String bairro, String localidade, String uf, String estado, int ddd) {
}
