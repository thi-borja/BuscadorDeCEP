package br.com.thborja.buscadorDeCep.teste;

import br.com.thborja.buscadorDeCep.modelos.Endereco;
import br.com.thborja.buscadorDeCep.modelos.EnderecoFormatado;
import br.com.thborja.buscadorDeCep.modelos.GeradorDeArquivo;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String busca = "";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();
        List<Endereco> listaDeBuscas = new ArrayList<>();

        while(!busca.equalsIgnoreCase("sair")) {

            System.out.println("Busque um CEP: ");
            busca = sc.nextLine();

            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            if (busca.length()<8 || busca.length()>9 || !busca.matches("^[0-9\\-]+$")){
                System.out.println("CEP Inválido. Insira um cep válido.");
                continue;
            }

            String endereco = "https://viacep.com.br/ws/" + busca.replace("-", "").trim() + "/json/";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            EnderecoFormatado end = gson.fromJson(response.body(), EnderecoFormatado.class);

            try {
                Endereco endFinal = new Endereco(end);
                System.out.println(endFinal);

                listaDeBuscas.add(endFinal);
            } catch (NumberFormatException e) {
                System.out.println("CEP Inválido. Insira um cep válido.");
                e.printStackTrace();
            }

            GeradorDeArquivo.geraArquivo(listaDeBuscas);

        }
    }
}
