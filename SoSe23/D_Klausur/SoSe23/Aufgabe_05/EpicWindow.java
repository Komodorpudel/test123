package SoSe23.D_Klausur.SoSe23.Aufgabe_05;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EpicWindow extends JFrame{
    int x = 300;
    int y = 300;
    int counter = 0;


    public EpicWindow(){
        super("EpicWindow");

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel clickedIndicator = new JLabel("Never clicked");
        add(clickedIndicator,BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1,2));

        JButton biggerButton = new JButton("BIGGER");
        biggerButton.addActionListener(e -> {
            x = (int) Math.round(x * 1.5);
            y = (int) Math.round(y * 1.25);
            setSize(x,y);
            counter++;

            clickedIndicator.setText("Clicked" + counter + "times");

        });
        southPanel.add(biggerButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }

        });
        southPanel.add(closeButton);
        add(southPanel, BorderLayout.SOUTH);

        // Finish
        setSize(x,y);
        setVisible(true);
    }

    public static void main (String [] args) {
        new EpicWindow();
    }
    
}
