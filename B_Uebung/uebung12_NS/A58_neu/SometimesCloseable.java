package B_Uebung.uebung12_NS.A58_neu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SometimesCloseable extends JFrame implements Runnable, ActionListener {

    // Attribute
    private JButton closeButton; // Hier implementieren, ansonsten kennt ihn die methode actionperformed nicht
    private Thread thread;

    public static void main (String [] args){
        new SometimesCloseable();

    }

    public SometimesCloseable() {
        super("Try to close me!");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        add(closeButton,BorderLayout.CENTER);

        // finish
        setSize(300,300);
        setVisible(true);

        // Thread starten
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(closeButton)) {
            dispose();
            thread.interrupt();
            System.exit(0);
        }
    }

    @Override
    public void run() {

        while(true) {
            try {
                if (closeButton.isEnabled() == true) {
                    closeButton.setEnabled(false);
                    closeButton.setText("Du musst warten");
                    Thread.sleep(1000);

                } // wenn disabled, dann auf enabled setzen und andersrum
                
                else {
                    closeButton.setEnabled(true);
                    closeButton.setText("Auf gehts!");
                    Thread.sleep(1000);
                }

            }

            catch(InterruptedException e) {
                break;
            }
        }
    }
}