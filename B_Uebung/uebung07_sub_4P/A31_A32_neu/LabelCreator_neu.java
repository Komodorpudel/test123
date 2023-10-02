package B_Uebung.uebung07_sub_4P.A31_A32_neu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LabelCreator_neu extends JFrame {

    public LabelCreator_neu(){

        super("Label Creator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        add (centerPanel, BorderLayout.CENTER);

        JButton createButton = new JButton("Add new label");
        createButton.addActionListener (new LabelCreatorListener_neu(centerPanel));
        add(createButton, BorderLayout.SOUTH);

        // Finish
        setSize(200, 200);
        setVisible(true);
    }   

    public static void main (String [] args){
        new LabelCreator_neu();
    }
    
}
