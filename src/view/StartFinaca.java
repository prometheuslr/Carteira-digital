package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.DebitoController;
import controller.ExtratoController;
import controller.SaldoController;

public class StartFinaca {
    public static void main(String[] args) {
        SaldoController saldoController = new SaldoController();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir quebra de linha após a leitura do número
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Por favor, digite um número válido.");
                scanner.nextLine(); // Limpar o buffer
                opcao = -1; // Definir uma opção inválida para continuar o loop
            }

            switch (opcao) {
                case 1:
                    saldoController.addSaldoFromUserInput();
                    break;

                case 2:
                    int tipoDespesa = exibirOpcoesTipoDespesa(scanner);
                    scanner.nextLine(); // Consumir quebra de linha

                    System.out.print("Informe o nome da despesa: ");
                    String nomeDespesa = scanner.nextLine();
                    System.out.print("Informe o valor da despesa: ");
                    double valorDespesa = scanner.nextDouble();

                    if (tipoDespesa == 1) {
                        DebitoController.registrarDebito(nomeDespesa, valorDespesa);
                    } /*else if (tipoDespesa == 2) {
                        
                        
                    } */else {
                        System.out.println("Opção inválida. Voltando ao menu principal.");
                    }

                    System.out.println("Despesa registrada com sucesso.");
                    break;

                case 3:
                    saldoController.mostraSaldo();
                    break;

                case 4:
                    ExtratoController.exibirExtrato();
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1 - Adicionar saldo");
        System.out.println("2 - Registrar despesa");
        System.out.println("3 - Mostrar saldo");
        System.out.println("4 - Mostrar extrato");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int exibirOpcoesTipoDespesa(Scanner scanner) {
        int tipoDespesa;
        while (true) {
            System.out.println("Selecione o tipo de despesa:");
            System.out.println("1 - Débito");
            //System.out.println("2 - );
            System.out.print("Digite o número correspondente: ");

            try {
                tipoDespesa = scanner.nextInt();
                if (tipoDespesa == 1 /*|| tipoDespesa == 2*/) {
                    break;
                } else {
                    System.out.println("Opção inválida. Por favor, digite 1 ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, digite um número válido.");
                scanner.nextLine(); // Limpar o buffer
            }
        }
        return tipoDespesa;
    }
}
