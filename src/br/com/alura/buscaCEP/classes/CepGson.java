package br.com.alura.buscaCEP.classes;

public class CepGson {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private int ddd;

    public CepGson(CepJson meuCepJson) {
        this.cep = meuCepJson.cep();
        this.logradouro = meuCepJson.logradouro();
        this.bairro = meuCepJson.bairro();
        this.localidade = meuCepJson.localidade();
        this.uf = meuCepJson.uf();
        this.estado = meuCepJson.estado();
        this.ddd = meuCepJson.ddd();
    }

    @Override
    public String toString() {
        return
                "\nCEP: " + cep +
                "\nLogradouro: " + logradouro +
                "\nBairro: " + bairro +
                "\nLocalidade: " + localidade +
                "\nUF: " + uf +
                "\nEstado: " + estado +
                "\nDDD: " + ddd;
    }
}
