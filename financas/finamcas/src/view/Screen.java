package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Screen {

    public Screen(){
        JTextField nome;
        JTextField valor;
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Financeiro");
        jFrame.setSize(800, 500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setFocusable(true);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

        JLabel labelNome = new JLabel("Nome");
        labelNome.setFont(new Font("Arial",Font.PLAIN, 14));
        labelNome.setBounds(20, 50, 100, 25);
        labelNome.setVisible(true);
        
        jFrame.add(labelNome);
        
        nome = new JTextField();
        nome.setBounds(60, 50, 100, 25);
        nome.setFont(new Font("Arial", Font.PLAIN,14));
        nome.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nome.setCaretColor(Color.BLACK);
        nome.setFocusable(true);
        nome.setVisible(true);

        jFrame.add(nome);


        JLabel labelValor = new JLabel("valor");
        labelValor.setFont(new Font("Arial",Font.PLAIN, 14));
        labelValor.setBounds(180, 50, 100, 25);
        labelValor.setVisible(true);
        
        jFrame.add(labelValor);
        
        valor = new JTextField();
        valor.setBounds(220, 50, 100, 25);
        valor.setFont(new Font("Arial", Font.PLAIN,14));
        valor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        valor.setCaretColor(Color.BLACK);
        valor.setFocusable(true);
        valor.setVisible(true);

        jFrame.add(valor);       

        JButton jbutton = new JButton("Aplicar");
        jbutton.setBounds(325, 50, 100, 25);

        jFrame.add(jbutton);       
        
        jbutton.setVisible(true);
        
       
    }





    
}
