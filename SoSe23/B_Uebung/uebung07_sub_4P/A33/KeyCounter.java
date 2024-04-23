package SoSe23.B_Uebung.uebung07_sub_4P.A33;


// Implementieren Sie ein Hauptanwendungsfenster KeyCounter.java nach folgenden Vorgaben:
    // 1. Das Fenster soll zu Beginn den Titel "KeyCounter: 0" tragen.
    // 2. Immer, wenn nur die Taste 'P' gedruckt wird, soll die im Titel angezeigte Zahl um 1 ¨erh¨oht werden.
    // 3. Wird 'P' zusammen mit der Shift-Taste gedruckt, soll die im Titel angezeigte Zahl ¨um 10 erh¨oht werden.
    // 4. Ein Klick auf das Fensterkreuz soll das Fenster schließen

// Necessary packages/classes:
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//

public class KeyCounter extends JFrame {

    // --------------------------------------

    // Attribute
    private int count;

    // --------------------------------------
    
    //Konstruktor
    public KeyCounter() {

        // 1. Das Fenster soll zu Beginn den Titel "KeyCounter: 0" tragen.
        setTitle("KeyCounter: 0");
        setSize(200, 100);

        // 4. Ein Klick auf das Fensterkreuz soll das Fenster schließen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        count = 0;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                // 3. Wird 'P' zusammen mit der Shift-Taste gedruckt, soll die im Titel angezeigte Zahl ¨um 10 erh¨oht werden.
                if ((e.getKeyChar() == 'p' || e.getKeyChar() == 'P') && e.isShiftDown()) {
                    count += 10;
                }

                // 2. Immer, wenn nur die Taste 'P' gedruckt wird, soll die im Titel angezeigte Zahl um 1 ¨erh¨oht werden.
                else if (e.getKeyChar() == 'p' || e.getKeyChar() == 'P') {
                    count += 1;
                }

                setTitle("KeyCounter: " + count);
            }
        });

        setFocusable(true);
    }

    // --------------------------------------

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KeyCounter());
    }

    // --------------------------------------
}
