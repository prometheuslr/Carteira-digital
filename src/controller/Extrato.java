package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Extrato {
     static final String FILENAME = null;
     static String getDataHoraAtual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataHoraAtual = new Date();
        return dateFormat.format(dataHoraAtual);
    }
// segunda parte 
    public static void salvarAlteracao(double valor) {
        try {
            if (!Files.exists(Paths.get(FILENAME))) {
                Files.createFile(Paths.get(FILENAME));
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true));
            writer.append(valor + " - " + getDataHoraAtual());
            writer.newLine();
            writer.close();

            System.out.println("Alteração salva com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a alteração: " + e.getMessage());
        }
    }
}
