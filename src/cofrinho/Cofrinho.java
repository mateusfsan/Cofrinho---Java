package cofrinho;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o cofrinho, contendo uma coleção de moedas.
 */
public class Cofrinho {
    private List<Moeda> listaMoedas = new ArrayList<>();

    // Adiciona uma moeda ao cofrinho
    public void adicionar(Moeda m) {
        listaMoedas.add(m);
    }

    // Remove a moeda informada (remove a primeira ocorrência)
    public boolean remover(Moeda m) {
        return listaMoedas.remove(m);
    }

    // Retorna uma cópia da lista de moedas
    public List<Moeda> listarMoedas() {
        return new ArrayList<>(listaMoedas);
    }

    // Soma o valor convertido de todas as moedas para Reais
    public double totalConvertido() {
        double total = 0.0;
        for (Moeda m : listaMoedas) {
            total += m.converter();
        }
        return total;
    }
}
