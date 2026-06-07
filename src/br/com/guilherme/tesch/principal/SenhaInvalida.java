package br.com.guilherme.tesch.principal;

import java.util.Scanner;

import br.com.guilherme.tesch.excecao.SenhaInvalidaException;
import br.com.guilherme.tesch.models.ValidaSenha;

public class SenhaInvalida {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        ValidaSenha verifica = new ValidaSenha();

        boolean cadastroConcluido = false;

    while(!cadastroConcluido){
        try{
        
            System.out.println("--- Cadastre sua senha --- ");
            System.out.print("Informe sua senha: ");

            var senha = sc.nextLine();
            verifica.setSenha(senha);
           
           
            verifica.validaTamanho();

            System.out.print("Repita sua senha novamente: ");
            var senha2 = sc.nextLine();
            
          
            verifica.setSenhaValida(senha2);

            if (verifica.senhasCoincidem()) {
                System.out.println("Senha cadastrada com sucesso!!");
                System.out.println("Senha: "+ verifica.getSenha());
            }
            else{
                System.out.println("Erro: As senhas não coincidem. Cadastro inválido");
            }

        }catch(SenhaInvalidaException e){
            System.out.println(e.getMessage());
        }
    }
        sc.close();
    }
}
