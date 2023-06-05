package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DebitoController {
    private static final String EXTRATO_FILE = "extrato.txt";
    
    //Método para registrar um débito no extrato
    public static void registrarDebito(double valorDebito, double saldoAnterior) {
        double novoSaldo = saldoAnterior - valorDebito;

        try {
            String dataHoraAtual = getDataHoraAtual();

            //Verifica se o arquivo de extrato existe, caso contrário, cria vai criar um novo
            if (!Files.exists(Paths.get(EXTRATO_FILE))) {
                Files.createFile(Paths.get(EXTRATO_FILE));
            }
            
            //Abre o arquivo em modo de escrita para implementar as informações do débito
            BufferedWriter writer = new BufferedWriter(new FileWriter(EXTRATO_FILE, true));
            writer.append("Despesa: R$ " + valorDebito + " - " + dataHoraAtual);
            writer.newLine();
            writer.append("Saldo: R$ " + novoSaldo + " - " + dataHoraAtual);
            writer.newLine();
            writer.close();

            System.out.println("Débito registrado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao registrar o débito: " + e.getMessage());
        }
    }

    
    //Método para conseguir a data e hora atual no formato de string
    private static String getDataHoraAtual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataHoraAtual = new Date();
        return dateFormat.format(dataHoraAtual);
    }
}
