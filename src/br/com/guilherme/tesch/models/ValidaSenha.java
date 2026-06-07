package br.com.guilherme.tesch.models;

import br.com.guilherme.tesch.excecao.SenhaInvalidaException;

public class ValidaSenha {

    private String senha;
    private String senhaValida;

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getSenhaValida(){
        return senhaValida;
    }

    public void setSenhaValida(String senhaValida){
        this.senhaValida = senhaValida;
    }

    public void validaTamanho(){
        if (senha == null || senha.length() < 8) {
            throw new SenhaInvalidaException("Erro: sua senha precisa ter mais de 8 caracteres");
        }
    }
    
    public boolean senhasCoincidem(){
        if (senhaValida != null && senhaValida.equals(senha)){
            return true;
        }
        return false;
    }

}



