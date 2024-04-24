package SoSe23.B_Uebung.uebung07_sub_4P.A31_A32_neu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WhackNMoles_neu extends JFrame implements ActionListener {

    private final int totalNumberOfMoles;
    private int numberOfMolesWhacked = 0;

    public WhackNMoles_neu(int totalNumberOfMoles){

        super ("Whack" + totalNumberOfMoles + " !");
        this.totalNumberOfMoles = totalNumberOfMoles;

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new GridLayout(0,3));

        for(int i = 1; i <= totalNumberOfMoles; i++){
            JButton temp = new JButton(String.valueOf(i));
            temp.addActionListener(this);
            add(temp);
        }

        // Finish
        pack();
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource(); // gibt mir eine reference zu dem Button, daher kann ich unten .setEnabled machen

        source.setEnabled(false);
        this.numberOfMolesWhacked ++;

        if(totalNumberOfMoles == numberOfMolesWhacked){
            dispose();
        }

    }

    public static void main (String[] args){
        new WhackNMoles_neu (10);
    }
    
}
