package br.com.thborja.buscadorDeCep.modelos;

public class Endereco {
    private final String cep;
    private final String rua;
    private final String complemento;
    private final String bairro;
    private final String localidade;
    private final String estado;
    private final String ddd;

    public Endereco(EnderecoFormatado end) {
        this.cep = end.cep();
        this.rua = end.logradouro();
        this.complemento = end.complemento();
        this.bairro = end.bairro();
        this.localidade = end.localidade();
        this.estado = end.uf();
        this.ddd = end.ddd();
    }

    @Override
    public String toString() {
        return  cep + "\n" +
                "Rua: " + rua + "\n" +
                "Complemento: " + complemento + "\n" +
                "Bairro: " + bairro + "\n" +
                "Localidade: " + localidade + "\n" +
                "Estado: " + estado + "\n" +
                "DDD: " + ddd + "\n";
    }
}
