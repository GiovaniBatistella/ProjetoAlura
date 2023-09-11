package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Search;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.principal.br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();


        while (!busca.equalsIgnoreCase("Sair")) {

            System.out.println("Digite um filme para busca: ");
            busca = teclado.nextLine();

            if (busca.equalsIgnoreCase("Sair")) {
                break;
            }

            String endereco = "https://www.omdbapi.com/?apikey=6b7be327&s=" + busca.replace(" ", "+");
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());
                String json = response.body();


                Search meuTituloOmdb = gson.fromJson(json, Search.class);
                System.out.println(meuTituloOmdb.toString());



            } catch (NumberFormatException e) {
                System.out.println("Ocorreu um erro");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifque o endereço! ");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
            }

        }


    }

}