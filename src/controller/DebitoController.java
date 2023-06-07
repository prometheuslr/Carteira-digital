package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Debito;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DebitoController {
    // Lista para armazenar as despesas
    private static List<Debito> despesas = new ArrayList<>();
    // Lista para armazenar o extrato
    private static List<String> extrato = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static BufferedWriter writer;

    // Método responsável por registrar um débito
    public static void registrarDebito(String nomeDespesa, double valorDespesa) {
        SaldoController saldoController = new SaldoController(); // Criar uma instância do SaldoController
    
        double saldoAnterior = saldoController.getSaldo();
        double saldoAtual = saldoAnterior - valorDespesa;
    
        // Verifica se o saldo atual é negativo
        if (saldoAtual < 0) {
            System.out.println("Saldo insuficiente!");
            System.out.print("Digite um novo valor para a despesa (ou 0 para voltar ao menu): ");
            double novoValorDespesa = scanner.nextDouble();
            // Verifica se o usuário deseja voltar ao menu
            if (novoValorDespesa == 0) {
                return;
            }
    
            // Atualiza o valor da despesa para o novo valor digitado
            valorDespesa = novoValorDespesa;
            saldoAtual = saldoAnterior - valorDespesa;
        }
    
        // Atualiza o saldo no objeto SaldoController
        saldoController.subtractSaldo(valorDespesa);
    
        // Chama o método para registrar a movimentação no extrato
        registrarMovimentacao(nomeDespesa, valorDespesa, saldoAtual);
    }

    // Método privado responsável por registrar a movimentação no extrato
    private static void registrarMovimentacao(String nomeDespesa, double valorDespesa, double saldoAtual) {
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formatter);
    
        String movimentacaoCompleta = dataHoraFormatada + " - Despesa registrada: " + nomeDespesa + " - Valor: -" + valorDespesa + " - Saldo atual: " + saldoAtual;
        
        try {
            writer = new BufferedWriter(new FileWriter("extrato.txt", true));
            writer.write(movimentacaoCompleta + System.lineSeparator()); // Escreve a movimentação completa no arquivo de extrato
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método getter para obter a lista de despesas
    public static List<Debito> getDespesas() {
        return despesas;
    }

    // Método getter para obter o extrato
    public static List<String> getExtrato() {
        return extrato;
    }
}
