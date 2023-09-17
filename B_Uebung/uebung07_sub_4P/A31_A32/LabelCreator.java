package B_Uebung.uebung07_sub_4P.A31_A32;


// Implementieren Sie ein Hauptanwendungsfenster LabelCreator.java nach folgenden Vorgaben:
    // 1. Das Fenster soll den Titel "Label Creator" tragen.
    // 2. Das Fenster soll 200 × 200 Pixel groß sein.
    // 3. Beim Klicken des Fensterkreuzes soll das Fenster geschlossen werden.
    // 4. Im Zentrum des Fensters soll ein zu Beginn leeres Panel sein.
    // 5. im Suden des Fensters soll ein Button mit dem Text ¨ "Add new label" sein.
    
    // 6. Immer wenn der Button gedruckt wird soll ein neues Label mit der aktuellen Uhrzeit ¨im Format HH:MM:SS im Panel des Fensters auftauchen, wobei der Text eine zuf¨allige RGB-Farbe haben soll.
    // 7. Implementieren Sie eine eigene Klasse LabelCreatorListener fur die Umsetzung ¨der Ereignisbehandlung, an deren Konstruktur Sie das Panel des Fensters ubergeben ¨k¨onnen.
    // Hinweis: Damit die Label nach der Erzeugung auch wirklich angezeigt werden, muss das Panel, welches die Labels beinhaltet, neu validiert werden.Verwenden Sie dazu die revalidate()-Methode des Panels.

// Necessary packages/classes:
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
//

public class LabelCreator extends JFrame {

    // --------------------------------------

    // Attribute
    private JButton addButton;
    private JPanel centerPanel;

    // --------------------------------------

    // Konstruktor
    public LabelCreator() {

        // 1. Das Fenster soll den Titel "Label Creator" tragen.
        setTitle("Label Creator");

        // 2. Das Fenster soll 200 × 200 Pixel groß sein.
        setSize(200, 200);
        
        setLayout(new BorderLayout());

        // 3. Beim Klicken des Fensterkreuzes soll das Fenster geschlossen werden.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 4. Im Zentrum des Fensters soll ein zu Beginn leeres Panel sein.
        centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);

        // 5. im Suden des Fensters soll ein Button mit dem Text ¨ "Add new label" sein.
        addButton = new JButton("Add new label");
        add(addButton, BorderLayout.SOUTH);

        // 6. Immer wenn der Button gedruckt wird soll ein neues Label mit der aktuellen Uhrzeit ¨im Format HH:MM:SS im Panel des Fensters auftauchen, wobei der Text eine zuf¨allige RGB-Farbe haben soll.
        ActionListener listener = new LabelCreatorListener(centerPanel);
        addButton.addActionListener(listener);
        
        // Fenster sichtbar machen
        setVisible(true);
    }

    // --------------------------------------

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LabelCreator());
    }

    // --------------------------------------
}
