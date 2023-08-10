
// Implementieren Sie ein Hauptanwendungsfenster DontMinimizeMe.java nach folgenden Vorgaben:
    // 1. Zu Beginn soll das Fenster den Titel "Don't minimize me!" tragen.
    // 2. Das Fenster soll die Gr¨oße 400 × 100 Pixel haben.
    // 3. Ein Klick auf das Fensterkreuz soll das Fenster schließen.
    // 4. Im Zentrum des Fensters soll ein zu Beginn leeres Raster mit 3 Spalten sein.
    // 5. Immer, wenn das Fenster minimiert wird, soll ein neuer Button mit dem Text "ouch"in das Raster eingefugt werden. ¨
    // 6. Wenn das Fenster aus der Minimierung zuruckgeholt wird, soll ¨ uberpr ¨ uft werden, ¨wieviele Buttons bereits enthalten sind. Wenn mehr als 3 Komponenten enthalten sind, soll der Titel zu "Stop iconifying me" ge¨andert werden,
    //    und bei mehr als 6 Komponenten zu "Dude, seriously, stop".
    // Hinweis: Verwenden Sie fur die Implementierung der Ereignisbehandlung eine passende ¨anonyme innere Unterklasse von WindowAdapter.

// Necessary packages/classes:
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//

public class DontMinimizeMe extends JFrame {

    // --------------------------------------

    // Attribute
    private JPanel panel;

    // --------------------------------------

    // Konstruktor
    public DontMinimizeMe() {

        // 1. Zu Beginn soll das Fenster den Titel "Don't minimize me!" tragen.
        setTitle("Don't minimize me!");

        // 2. Das Fenster soll die Gr¨oße 400 × 100 Pixel haben.
        setSize(400, 100);

        // 3. Ein Klick auf das Fensterkreuz soll das Fenster schließen.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Im Zentrum des Fensters soll ein zu Beginn leeres Raster mit 3 Spalten sein.
        panel = new JPanel(new GridLayout(1, 3));
        add(panel);

        setVisible(true);
        
        addWindowListener(new WindowAdapter() {

            // 5. Immer, wenn das Fenster minimiert wird, soll ein neuer Button mit dem Text "ouch"in das Raster eingefugt werden. ¨
            @Override
            public void windowIconified(WindowEvent e) {
                JButton button = new JButton("ouch");
                panel.add(button);
                panel.revalidate();
            }

            // 6. Wenn das Fenster aus der Minimierung zuruckgeholt wird, soll ¨ uberpr ¨ uft werden, ¨wieviele Buttons bereits enthalten sind. Wenn mehr als 3 Komponenten enthalten sind, soll der Titel zu "Stop iconifying me" ge¨andert werden,
            //    und bei mehr als 6 Komponenten zu "Dude, seriously, stop".
            // Hinweis: Verwenden Sie fur die Implementierung der Ereignisbehandlung eine passende ¨anonyme innere Unterklasse von WindowAdapter.
            @Override
            public void windowDeiconified(WindowEvent e) {

                // Mehr als 3, weniger als 6
                if (panel.getComponentCount() > 3 && panel.getComponentCount() <= 6 ) {
                    setTitle("Stop iconifying me");
                    return;
                }

                // Mehr als 6
                if (panel.getComponentCount() > 6) {
                    setTitle("Dude, seriously, stop");
                    return;
                }
            }
        });
    }

    // --------------------------------------

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DontMinimizeMe());
    }

    // --------------------------------------

}
