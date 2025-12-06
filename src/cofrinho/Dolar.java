package cofrinho;

import java.net.URI;
import java.net.URL;

public class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public double converter() {
        double cotacao = ConversorMoeda.obterCotacao("USD", "BRL");
        if (cotacao == 0) {
            // Fallback se API falhar
            cotacao = 5.30;
        }
        return this.valor * cotacao;
    }

    @Override
    public String info() {
        return String.format("Dólar: US$%.2f", valor);
    }
    
    public void exemploUsoURL() {
        try {
            String urlString = "http://exemplo.com";
            URL url = URI.create(urlString).toURL();
            System.out.println("URL criada com sucesso: " + url);
        } catch (Exception e) {
            System.err.println("Erro ao criar URL: " + e.getMessage());
        }
    }
}