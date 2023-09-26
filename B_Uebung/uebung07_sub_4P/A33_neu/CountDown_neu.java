package B_Uebung.uebung07_sub_4P.A33_neu;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CountDown_neu extends JFrame {

    public CountDown_neu(){
        String input = JOptionPane.showInputDialog("natürliche Zahl eingeben:");
        Integer number = Integer.parseInt(input);

        while (number > 0){

            JOptionPane.showMessageDialog(null, number);
            number--;
        }

    }

    public static void main (String [] args){

        new CountDown_neu();
    }
    
}
