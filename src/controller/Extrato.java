package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Saldo;

public class Extrato extends Saldo {
    @Override
    public double getValorSaldo() {
        // TODO Auto-generated method stub
        return super.getValorSaldo();
    }

    static final String FILENAME = "extrato.txt";
     static String getDataHoraAtual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataHoraAtual = new Date();
        return dateFormat.format(dataHoraAtual);
    }
// segunda parte 
    public  void salvarAlteracao() {
        try {
            if (!Files.exists(Paths.get(FILENAME))) {
                Files.createFile(Paths.get(FILENAME));
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true));
            writer.append(getValorSaldo() + " - " + getDataHoraAtual());
            writer.newLine();
            writer.close();

            System.out.println("Alteração salva com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a alteração: " + e.getMessage());
        }
    }
}
