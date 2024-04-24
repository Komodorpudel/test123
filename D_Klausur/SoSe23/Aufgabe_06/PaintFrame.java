package SoSe23.D_Klausur.SoSe23.Aufgabe_06;

import javax.swing.JFrame;

public class PaintFrame extends JFrame {

    public PaintFrame() {
        super("PaintFrame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new PaintPanel());


        // Finish
        pack();
        setVisible(true);
    }

    public static void main (String [] args){
        new PaintFrame();
    }
    
}
