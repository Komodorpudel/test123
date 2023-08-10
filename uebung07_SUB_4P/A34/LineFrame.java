
// Implementieren Sie ein Hauptanwendungsfenster LineFrame.java nach folgenden Vorgaben:
    // 1. Das Fenster soll den Titel "Line Frame" tragen.
    // 2. Das Fenster soll im Zentrum eine Zeichenfl¨ache der vorherigen Teilaufgabe enthalten.
    // 3. Ein Klick auf das Fensterkreuz soll das Fenster schließen und die Anwendung beenden.

// Necessary packages/classes:
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
//

public class LineFrame extends JFrame {

    // --------------------------------------

    // Attribute
    private LinePanel linePanel;

    // --------------------------------------

    // Konstruktor
    public LineFrame() {

        // 1. Das Fenster soll den Titel "Line Frame" tragen.
        setTitle("Line Frame");

        // 2. Das Fenster soll im Zentrum eine Zeichenfl¨ache der vorherigen Teilaufgabe enthalten.
        linePanel = new LinePanel();
        add(linePanel);

        // 3. Ein Klick auf das Fensterkreuz soll das Fenster schließen und die Anwendung beenden.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
    }

    // --------------------------------------

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LineFrame frame = new LineFrame();
            frame.setVisible(true);
        });
    }

    // --------------------------------------

}
