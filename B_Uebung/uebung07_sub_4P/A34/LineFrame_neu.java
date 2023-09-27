package B_Uebung.uebung07_sub_4P.A34;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class LineFrame_neu extends JFrame {

    public LineFrame_neu(){

        super("Line Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new LinePanel_neu(), BorderLayout.CENTER);

        // Finally
        pack();
        setVisible(true);

    }

    public static void main(String [] args){

        new LineFrame_neu();
    }
    
}
