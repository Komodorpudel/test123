package B_Uebung.uebung09_sub_1_5P.A43_44_neu;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.util.Random;

public class RandomNumberFrame_neu extends JFrame {

    public RandomNumberFrame_neu(int n) {

        super ("Random Number Frame");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(0,3));

        Random myRandom = new Random();



        for (int i = 0; i < n; i++){

            int x = myRandom.nextInt(100);

            String s = String.valueOf(x);

            add(new JLabel("Current time" + s));
        }

        pack();

        setVisible(true);


    }


    public static void main (String [] args){
        new RandomNumberFrame_neu(20);
    }
    
}
