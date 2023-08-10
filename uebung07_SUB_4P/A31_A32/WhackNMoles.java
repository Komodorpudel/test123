package uebung07_sub_4P.A31_A32;


// Implementieren Sie ein Hauptanwendungsfenster WhackNMoles.java nach folgenden Vorgaben:
    // 1. Im Zentrum des Fensters soll eine beliebige Anzahl x von Buttons in einem Raster von 3 Spalten angeordnet sein.
    // 2. Die Anzahl der Buttons wird beim Erstellen des Fensters an den Konstruktor ubergeben, ¨die Buttons haben den Text 1, 2 usw. bis x.
    // 3. Das Fenster soll den Titel "Whack x Moles!" tragen, mit Anzahl der Buttons x.
    // 4. Jeder der Buttons soll durch einmaliges Drucken deaktiviert werden und sobald jeder ¨Button einmal gedruckt wurde, soll das Fenster geschlossen werden. ¨
    // 5. Verwenden Sie die Fensterklasse als Ereignisabh¨orer.
    // 6. Beim Drucken des Fensterkreuzes soll nichts passieren.

// Necessary packages/classes:
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WhackNMoles extends JFrame implements ActionListener {

    // --------------------------------------

    // Attribute
    private int buttonCount;
    private int clickedButtons;
    private JButton[] buttons;

    // --------------------------------------

    // Konstruktor
    // 2. Die Anzahl der Buttons wird beim Erstellen des Fensters an den Konstruktor ubergeben, ¨die Buttons haben den Text 1, 2 usw. bis x.
    public WhackNMoles(int numberOfButtons) {
        
        // 1. Im Zentrum des Fensters soll eine beliebige Anzahl x von Buttons in einem Raster von 3 Spalten angeordnet sein.
        setLayout(new GridLayout(0, 3));

        // 3. Das Fenster soll den Titel "Whack x Moles!" tragen, mit Anzahl der Buttons x.
        setTitle("Whack " + numberOfButtons + " Moles!");
        setSize(400, 200);

        buttonCount = numberOfButtons;
        clickedButtons = 0;

        // SAH: Bottons erstellen
        buttons = new JButton[buttonCount];

        for (int i = 0; i < buttonCount; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));

            // Ereignisabhörer (diese Klasse) hinzufügen
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
    }

    // --------------------------------------

    // actionPerformed
    // 4. Jeder der Buttons soll durch einmaliges Drucken deaktiviert werden und sobald jeder ¨Button einmal gedruckt wurde, soll das Fenster geschlossen werden. ¨
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        clickedButton.setEnabled(false);
        clickedButtons++;

        if (clickedButtons == buttonCount) {
            dispose();
        }
    }

    // --------------------------------------
    
    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            // Auf 6 Buttons gesetzt
            WhackNMoles frame = new WhackNMoles(6);

            // 6. Beim Drucken des Fensterkreuzes soll nichts passieren.
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    // --------------------------------------
}
