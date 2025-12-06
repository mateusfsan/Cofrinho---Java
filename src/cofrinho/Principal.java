package cofrinho;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe principal que apresenta um menu ao usuário para manipular o cofrinho.
 */
public class Principal {
    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    private static final Cofrinho cofrinho = new Cofrinho();

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            mostrarMenu();
            int opcao = lerInt("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    opcaoAdicionar();
                    break;
                case 2:
                    opcaoRemover();
                    break;
                case 3:
                    opcaoListar();
                    break;
                case 4:
                    opcaoTotalConvertido();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Encerrando. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Cofrinho ---");
        System.out.println("1 - Adicionar moeda");
        System.out.println("2 - Remover moeda (por índice)");
        System.out.println("3 - Listar moedas");
        System.out.println("4 - Calcular total convertido para Real");
        System.out.println("0 - Sair");
    }

    private static void opcaoAdicionar() {
        System.out.println("\nEscolha o tipo de moeda:");
        System.out.println("1 - Real");
        System.out.println("2 - Dólar");
        System.out.println("3 - Euro");
        int tipo = lerInt("Tipo: ");
        double valor = lerDouble("Valor: ");

        Moeda m;
        switch (tipo) {
            case 1:
                m = new Real(valor);
                break;
            case 2:
                m = new Dolar(valor);
                break;
            case 3:
                m = new Euro(valor);
                break;
            default:
                System.out.println("Tipo inválido. Operação cancelada.");
                return;
        }
        cofrinho.adicionar(m);
        System.out.println("Moeda adicionada: " + m.info());
    }

    private static void opcaoRemover() {
        List<Moeda> lista = cofrinho.listarMoedas();
        if (lista.isEmpty()) {
            System.out.println("Cofrinho vazio. Nada a remover.");
            return;
        }
        System.out.println("\nMoedas atuais:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, lista.get(i).info());
        }
        int idx = lerInt("Informe o número da moeda a remover (0 para cancelar): ");
        if (idx <= 0 || idx > lista.size()) {
            System.out.println("Remoção cancelada ou índice inválido.");
            return;
        }
        Moeda removida = lista.get(idx - 1);
        boolean ok = cofrinho.remover(removida);
        if (ok) {
            System.out.println("Removida: " + removida.info());
        } else {
            System.out.println("Não foi possível remover a moeda selecionada.");
        }
    }

    private static void opcaoListar() {
        List<Moeda> lista = cofrinho.listarMoedas();
        if (lista.isEmpty()) {
            System.out.println("Cofrinho vazio.");
            return;
        }
        System.out.println("\n--- Conteúdo do Cofrinho ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("%d - %s (convertido: R$ %.2f)\n", i + 1, lista.get(i).info(), lista.get(i).converter());
        }
    }

    private static void opcaoTotalConvertido() {
        double total = cofrinho.totalConvertido();
        System.out.printf("\nTotal convertido para Real: R$ %.2f\n", total);
    }

    private static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. " + mensagem);
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada inválida. " + mensagem);
            scanner.next();
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }
}
