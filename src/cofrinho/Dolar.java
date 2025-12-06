package cofrinho;

/**
 * Representa moeda Dólar. Conversão para Real por uma cotação fixa.
 */
public class Dolar extends Moeda {
    // Cotação de exemplo (1 USD = 5.30 BRL)
    private static final double COTACAO = 5.30;

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return String.format("Dólar: %.2f", valor);
    }

    @Override
    public double converter() {
        return valor * COTACAO;
    }
}
