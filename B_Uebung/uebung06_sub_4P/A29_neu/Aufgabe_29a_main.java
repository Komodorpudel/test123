package SoSe23.B_Uebung.uebung06_sub_4P.A29_neu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class Aufgabe_29a_main extends JFrame {

    public Aufgabe_29a_main(){

        super("Aufgabe29a");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font myFont = new Font ("Arial", Font.PLAIN, 20);

        // North
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(200,200,200));

        JLabel labelKontonummer = new JLabel("Kontonummer: ");
        labelKontonummer.setFont(myFont);
        northPanel.add(labelKontonummer);

        JTextField textFieldKontonummer = new JTextField(20);
        textFieldKontonummer.setFont(myFont);
        northPanel.add(textFieldKontonummer);
        
        add(northPanel, BorderLayout.NORTH);

        // South
        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(150,150,150));

        JButton buttonOkay = new JButton("Okay");
        southPanel.add(buttonOkay);

        JButton buttonAbbrechen = new JButton("Abbrechen");
        southPanel.add(buttonAbbrechen);

        add(southPanel, BorderLayout.SOUTH);

        // finish
        pack();
        setVisible(true);

    }

    public static void main(String[]args){
        new Aufgabe_29a_main();
    }
    
}
