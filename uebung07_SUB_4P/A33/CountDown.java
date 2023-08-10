
// Implementieren Sie eine Hauptprogrammklasse CountDown, die
    // 1. mithilfe eines Eingabe-Dialogs um die Eingabe einer naturlichen Zahl bittet und ¨
    // 2. Danach genauso viele Nachrichten-Dialoge ¨offnet, die von der eingegebenen Zahl anherunterz¨ahlen.
    // 3. Die Eingabe der Zahl 5 soll also dazu fuhren, dass nacheinander Dialoge mit den ¨
    //    Nachrichten 5, 4, 3, 2 und 1 ge¨offnet werden, d.h. der n¨achste Dialog ¨offnet sich erst,
    //    nachdem der vorherige geschlossen wurde.

// Necessary packages/classes:
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
//

public class CountDown {

    // --------------------------------------

    // Attribute
    String input;
    int number;

    // --------------------------------------

    // Konstruktor
    public CountDown() {
        // 1. mithilfe eines Eingabe-Dialogs um die Eingabe einer naturlichen Zahl bittet und ¨
        input = JOptionPane.showInputDialog("Bitte Natüriche Zahl eingeben:");
        number = Integer.parseInt(input);

        // 2. Danach genauso viele Nachrichten-Dialoge ¨offnet, die von der eingegebenen Zahl 
        for (int i = number; i >= 1; i--) {

            // 3. Die Eingabe der Zahl 5 soll also dazu fuhren, dass nacheinander Dialoge mit den ¨
            //    Nachrichten 5, 4, 3, 2 und 1 ge¨offnet werden, d.h. der n¨achste Dialog ¨offnet sich erst,
            //    nachdem der vorherige geschlossen wurde.
            JOptionPane.showMessageDialog(null, i);
        }
    }

    // --------------------------------------

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CountDown());
    }

    // --------------------------------------
}
