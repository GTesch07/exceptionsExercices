package br.com.guilherme.tesch.excecao;

public class ErroDeDivsaoPorZero extends RuntimeException{
    private String mensagem;

    public ErroDeDivsaoPorZero(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage(){
        return this.mensagem;
    }
    
}
