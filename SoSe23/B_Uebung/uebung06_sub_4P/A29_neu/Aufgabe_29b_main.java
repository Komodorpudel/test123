package SoSe23.B_Uebung.uebung06_sub_4P.A29_neu;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Aufgabe_29b_main extends JFrame {

    public Aufgabe_29b_main(){

        super("PIN");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Textfield ganz oben
        JTextField textFieldPin = new JTextField(20);
        textFieldPin.setEnabled(true);
        add(textFieldPin,BorderLayout.NORTH);

        // Ziffern
        int [] numbers = {7,8,9,4,5,6,1,2,3,0};

        JPanel southPanel = new JPanel();

        southPanel.setLayout(new GridLayout(0, 3));

        for (int number : numbers){
            southPanel.add(new JButton(String.valueOf(number)));
        }

        southPanel.add(new JButton("Clear"));
        southPanel.add(new JButton("Okay"));
        add(southPanel,BorderLayout.SOUTH);

        // Finish
        pack();
        setVisible(true);

    }

    public static void main(String[]args){
        new Aufgabe_29b_main();
    }
    
}
