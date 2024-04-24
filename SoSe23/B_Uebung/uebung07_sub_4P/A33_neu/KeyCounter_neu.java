package SoSe23.B_Uebung.uebung07_sub_4P.A33_neu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class KeyCounter_neu extends JFrame {

    private int counter = 0;

    public KeyCounter_neu(){

        super("KeyCounter: 0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed (KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_P) {
                    if (e.isShiftDown()){
                        counter = counter + 10;
                    }
                    else {
                        counter = counter + 1;
                    }
                }

                setTitle("KeyCounter: " + counter);
            }

        });

        // Finish
        //pack(); // zu klein
        setSize(400, 400);
        setVisible(true);

    }
    
    public static void main (String[] args){
        new KeyCounter_neu();
    }
}
