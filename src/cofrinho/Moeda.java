package cofrinho;

/**
 * Classe abstrata que representa uma moeda genérica.
 * Contém o valor e os métodos abstratos a serem implementados pelas moedas concretas.
 */
public abstract class Moeda {
    protected double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Retorna uma descrição da moeda (ex: "Dólar: 5.00")
    public abstract String info();

    // Converte o valor dessa moeda para Reais
    public abstract double converter();

    @Override
    public String toString() {
        return info();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Moeda outra = (Moeda) obj;
        return Double.compare(this.valor, outra.valor) == 0;
    }
}
