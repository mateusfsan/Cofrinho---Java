package cofrinho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class ConversorMoeda {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "966c8456a4042afc308be881";

    public static double obterCotacao(String moedaOrigem, String moedaDestino) {
        try {
            // Novo endpoint v6: https://v6.exchangerate-api.com/v6/API_KEY/latest/moedaOrigem
            String urlString = API_URL + API_KEY + "/latest/" + moedaOrigem;
            URL url = URI.create(urlString).toURL();
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setConnectTimeout(5000);

            if (conexao.getResponseCode() != 200) {
                System.err.println("Erro na API: código " + conexao.getResponseCode());
                return 0;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder resposta = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                resposta.append(linha);
            }
            reader.close();

            // Busca o campo "conversion_rates": { ... "BRL": 4.43, ... }
            String json = resposta.toString();
            String bloco = "conversion_rates";
            int blocoIdx = json.indexOf(bloco);
            if (blocoIdx == -1) return 0;
            int blocoStart = json.indexOf("{", blocoIdx);
            int blocoEnd = json.indexOf("}", blocoStart);
            if (blocoStart == -1 || blocoEnd == -1) return 0;
            String ratesJson = json.substring(blocoStart, blocoEnd);
            String busca = "\"" + moedaDestino + "\":";
            int idx = ratesJson.indexOf(busca);
            if (idx == -1) return 0;
            int start = idx + busca.length();
            while (start < ratesJson.length() && 
                   (ratesJson.charAt(start) == ' ' || ratesJson.charAt(start) == '"')) start++;
            int end = ratesJson.indexOf(",", start);
            if (end == -1) end = ratesJson.length();
            String valorStr = ratesJson.substring(start, end).replaceAll("[^0-9.]", "");
            double cotacao = Double.parseDouble(valorStr);
            System.out.println("Cotação " + moedaOrigem + "->" + moedaDestino + ": " + cotacao);
            return cotacao;

        } catch (Exception e) {
            System.err.println("Erro ao obter cotação: " + e.getMessage());
            return 0;
        }
    }
}