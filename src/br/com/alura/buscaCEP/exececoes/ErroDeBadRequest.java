package br.com.alura.buscaCEP.exececoes;

public class ErroDeBadRequest extends RuntimeException {
    private String mensagem;

    public ErroDeBadRequest(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage(){
        return this.mensagem;
    }
}
