package cofrinho;

/**
 * Representa moeda Euro. Conversão para Real por uma cotação fixa.
 */
public class Euro extends Moeda {
    // Cotação de exemplo (1 EUR = 5.90 BRL)
    private static final double COTACAO = 5.90;

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return String.format("Euro: %.2f", valor);
    }

    @Override
    public double converter() {
        return valor * COTACAO;
    }
}
