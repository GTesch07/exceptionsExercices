package br.com.guilherme.tesch.models;

import br.com.guilherme.tesch.excecao.ErroDeDivsaoPorZero;

public class Calculos {

    private double n1;
    private double divisor;

    public  double getN1(){
        return n1;
    }

    public void setN1(double n1){
        this.n1 = n1;
    }

    public double getDivisor(){
        return divisor;
    }

    public void setDivisor(double divisor){
        this.divisor = divisor;
    }

    public void calculaDivisao(){
        if (divisor == 0) {
            throw new ErroDeDivsaoPorZero("Erro detectado, divisor é igual a zero");
        }   
        double resultado = n1 / divisor;
        System.out.printf("%.2f", resultado);
    }



}
