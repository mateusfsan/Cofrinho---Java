package cofrinho;

public class Euro extends Moeda {

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public double converter() {
        double cotacao = ConversorMoeda.obterCotacao("EUR", "BRL");
        if (cotacao == 0) {
            // Fallback se API falhar
            cotacao = 5.90;
        }
        return this.valor * cotacao;
    }

    @Override
    public String info() {
        return String.format("Euro: €%.2f", valor);
    }
}