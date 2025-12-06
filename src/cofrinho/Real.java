package cofrinho;

/**
 * Representa moeda Real. A conversão para Real retorna o próprio valor.
 */
public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return String.format("Real: %.2f", valor);
    }

    @Override
    public double converter() {
        return valor;
    }
}
