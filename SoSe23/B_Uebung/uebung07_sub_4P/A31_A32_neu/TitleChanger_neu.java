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

            // Zusammengekürzte Version von anonymer function siehe unten. Funktioniert nur bei funktionalen Schnittstellen mit einer Methode
            temp.addActionListener(e -> {
                JButton source = (JButton) e.getSource();
                setTitle("Title changed by " + source.getText());
            });

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
