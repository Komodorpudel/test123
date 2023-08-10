package uebung07_SUB_4P.A31_A32;


// Implementieren Sie ein Hauptanwendungsfenster TitleChanger.java nach folgenden Vorgaben:
    // 1. Das Fenster soll zu Beginn den Titel "TitleChanger" und eine Gr¨oße von 350 × 100 Pixeln haben.
    // 2. Beim Drucken des Fensterkreuzes soll das Fenster geschlossen und das Programm ¨beendet werden.
    // 3. Im Zentrum des Fensters sollen vier Buttons mit den Texten Button 1 bis Button 4 in einem 2 × 2-Raster angeordnet sein.
    // 4. Wenn auf einen der Buttons gedruckt wird, soll der Titel des Fensters zu ¨ Title changed by Button x ge¨andert werden, wobei x die Nummer des jeweiligen Buttons sein soll.
    // 5. Verwenden Sie fur die Implementierung des Ereignisabh ¨ ¨orers Lambda-Ausdrucke f ¨ ur ¨ die jeweiligen Buttons.

// Necessary packages/classes:
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
//

public class TitleChanger extends JFrame {

    // --------------------------------------

    // Attribute (declare variables)
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    // --------------------------------------

    // Konstruktor
    public TitleChanger() {

        // 1. Das Fenster soll zu Beginn den Titel "TitleChanger" und eine Gr¨oße von 350 × 100 Pixeln haben.
        setTitle("TitleChanger");
        setSize(350, 100);

        // 2. Beim Drucken des Fensterkreuzes soll das Fenster geschlossen und das Programm ¨beendet werden.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Im Zentrum des Fensters sollen vier Buttons mit den Texten Button 1 bis Button 4 in einem 2 × 2-Raster angeordnet sein.
        setLayout(new GridLayout(2, 2));
        
        // 4. Wenn auf einen der Buttons gedruckt wird, soll der Titel des Fensters zu ¨ Title changed by Button x ge¨andert werden, wobei x die Nummer des jeweiligen Buttons sein soll.
        // 5. Verwenden Sie fur die Implementierung des Ereignisabh ¨ ¨orers Lambda-Ausdrucke f ¨ ur ¨ die jeweiligen Buttons.
        button1 = new JButton("Button 1");
        button1.addActionListener((ActionEvent e) -> setTitle("Title changed by Button 1"));
        
        button2 = new JButton("Button 2");
        button2.addActionListener((ActionEvent e) -> setTitle("Title changed by Button 2"));
        
        button3 = new JButton("Button 3");
        button3.addActionListener((ActionEvent e) -> setTitle("Title changed by Button 3"));
        
        button4 = new JButton("Button 4");
        button4.addActionListener((ActionEvent e) -> setTitle("Title changed by Button 4"));
        
        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }

    // --------------------------------------

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TitleChanger frame = new TitleChanger();

            // SAH: Visibility via main erlaubt mehr Spielraum. Eventuell will man, dass mehrere Windows gleichzeitig öffnen
            frame.setVisible(true);
        });
    }

    // --------------------------------------

}
