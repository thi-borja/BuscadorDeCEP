package br.com.thborja.buscadorDeCep.modelos;

public class Endereco {
    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String localidade;
    private String estado;
    private String ddd;

    public Endereco(String cep, String rua, String complemento, String bairro, String localidade, String estado, String ddd) {
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.estado = estado;
        this.ddd = ddd;
    }

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
