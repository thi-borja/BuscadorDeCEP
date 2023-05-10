package br.com.thborja.buscadorDeCep.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {

    public static void geraArquivo(List<Endereco> list) throws IOException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();

        FileWriter escrita = new FileWriter("buscas.json");

        escrita.write(gson.toJson(list));
        escrita.close();
    }

}
