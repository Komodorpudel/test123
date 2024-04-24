package SoSe23.B_Uebung.uebung09_sub_1_5P.A43_44_neu;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestFrame_neu extends JFrame {

    JButton closeButton; // Close button muss hier sein, weil sonst in actionPerformed nicht bekannt

    public TestFrame_neu(){

        closeButton = new JButton("Close");
    }

    public void actionPerformed(ActionEvent e){

        Object o = e.getSource(); // ICh kann auch direkt e.getSource() instanceof JButton macht.

        if (o instanceof JButton){
            
            JButton b = (JButton) e.getSource();

            if (closeButton.equals(b)){

                JOptionPane.showMessageDialog(this, "exiting...");

                dispose();
            }

        }

    }
    
}
