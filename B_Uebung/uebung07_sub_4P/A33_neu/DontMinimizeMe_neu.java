package B_Uebung.uebung07_sub_4P.A33_neu;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DontMinimizeMe_neu extends JFrame {

    private int count = 0;

    public DontMinimizeMe_neu(){

        super("Don't minimize me!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,3));

        addWindowListener(new WindowAdapter() { // anonyme Klasse hier


            public void windowIconified(WindowEvent e){
                add(new JButton("ouch"));
            }

            @Override
            public void windowDeiconified(WindowEvent e){

                count ++;

                if (count > 6) {

                    setTitle("Dude, seriously, stop");
                }

                else if (count > 3){
                    setTitle("Stop iconifiny me!");
                }

            }
        });

        // Finally
        setSize(400,100);
        setVisible(true);
        
    }

    public static void main (String[] args){
        new DontMinimizeMe_neu();
    }
    
}
