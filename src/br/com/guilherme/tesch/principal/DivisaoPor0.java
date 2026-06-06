package br.com.guilherme.tesch.principal;

import java.util.Scanner;

import br.com.guilherme.tesch.excecao.ErroDeDivsaoPorZero;
import br.com.guilherme.tesch.models.Calculos;

public class DivisaoPor0 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        Calculos calcula = new Calculos();
        //Crie um programa simples que solicita dois números ao usuário e realiza a /divisão do primeiro pelo segundo. Utilize o bloco try/catch para tratar a exceção que pode ocorrer caso o usuário informe 0 como divisor.
        try{
             System.out.print("Digite o primeiro número: ");

             var recebeN1 = sc.nextDouble();

             calcula.setN1(recebeN1);

             System.out.print("Digite o segundo número: ");

             var recebeN2 = sc.nextDouble();

             calcula.setDivisor(recebeN2);

             calcula.calculaDivisao();
        }catch(ErroDeDivsaoPorZero e){
            System.out.println(e.getMessage());
        }
      

        sc.close();
    }
}
