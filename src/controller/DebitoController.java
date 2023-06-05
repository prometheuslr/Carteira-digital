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

    public static void registrarDebito(double valorDebito, double saldoAnterior) {
        double novoSaldo = saldoAnterior - valorDebito;

        try {
            String dataHoraAtual = getDataHoraAtual();

            if (!Files.exists(Paths.get(EXTRATO_FILE))) {
                Files.createFile(Paths.get(EXTRATO_FILE));
            }

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

    

    private static String getDataHoraAtual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataHoraAtual = new Date();
        return dateFormat.format(dataHoraAtual);
    }
}
