package br.com.guilherme.tesch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import br.com.guilherme.tesch.excecao.ErroConsultaGitHubException;
import br.com.guilherme.tesch.models.UserGit;

//Desenvolva um programa em Java que permite aos usuários consultar informações sobre um usuário do GitHub (utilize a API pública do GitHub para obter os dados). Crie uma classe de exceção personalizada, ErroConsultaGitHubException, que estende RuntimeException. Lance essa exceção quando o nome de usuário não for encontrado. No bloco catch, trate de forma específica essa exceção, exibindo uma mensagem amigável.


public class ConsultaGitHub {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        UserGit user = new UserGit();

        try{
            System.out.print("Digite o usuário do GitHub que deseja consultar: ");
            var leitura = sc.nextLine();
            user.setUser(leitura);

            String endereco = "https://api.github.com/users/" + user.getUser();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).header("Accept", "application/vnd.github.v3+json").build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                throw new ErroConsultaGitHubException("Usuário não encontrado no GitHub.");
            }

            String json = response.body();

            System.out.println(json);

        }catch(IOException | InterruptedException e ){
            System.out.println("Opss... Houve um erro durante a consulta à API do GitHub.");
            e.printStackTrace();
        }
        
        catch(ErroConsultaGitHubException e){
            System.out.println(e.getMessage());
        }
    
        sc.close();
    }
}
