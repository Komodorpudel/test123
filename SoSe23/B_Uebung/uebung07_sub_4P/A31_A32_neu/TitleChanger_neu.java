package SoSe23.B_Uebung.uebung07_sub_4P.A31_A32_neu;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TitleChanger_neu extends JFrame {

    public TitleChanger_neu(){

        super ("TitleChanger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(0, 2));

        for (int i = 1; i <= 4; i++){

            JButton temp = new JButton("Button" + i);

            // Zusammengekürzte Version von anonymer function siehe unten. Funktioniert nur bei funktionalen Schnittstellen mit einer Methode (interfaces with exactely one abstract method)

            // Lambda Expression:
            temp.addActionListener(e -> { // Compiler knows because of the context (addActionListener) that we wanna create an ActionListener and override actionPerformed (because it is an functional interface)
                JButton source = (JButton) e.getSource();
                setTitle("Title changed by " + source.getText());
            });

            // Anonymoues Inner Class:
        /*  temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                setTitle("Title changed by " + source.getText());
            }
        }); */

            add(temp);

        }

        // Finish
        setSize(350,100);
        pack();
        setVisible(true);
        
    }

    public static void main (String[]args){
        new TitleChanger_neu();
    }
    
}
