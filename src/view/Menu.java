package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    protected static void exibirMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1 - Adicionar saldo");
        System.out.println("2 - Registrar despesa");
        System.out.println("3 - Mostrar saldo");
        System.out.println("4 - Mostrar extrato");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    protected static int exibirOpcoesTipoDespesa(Scanner scanner) {
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
