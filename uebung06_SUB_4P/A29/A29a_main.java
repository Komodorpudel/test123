package uebung06_sub_4P.A29;


// Aufgabenstellung:
    // 1. Es soll den Titel Aufgabe29a haben.

    // 2. Es soll im Norden von links nach rechts angeordnet die Beschriftung Kontonummer und ein aktiviertes einzeiliges Textfeld der Breite 20 anzeigen.
    // 2.a Beschriftung und Textfeld sollen beide dieselbe Schrift mit Schriftgr¨oße 20 haben.

    // 3. Es soll im Suden von links nach rechts angeordnet zwei Schaltfl ¨ ¨achen mit dem Text Okay und Abbrechen anzeigen.
    // 4. Der Nord- und der Sudbereich sollen unterschiedliche Graufarben als Hintergrundfarbe ¨haben.
    // 5. Durch Klicken auf das Fensterkreuz soll die Anwendung beendet werden.
//

// Necessary packages/classes:
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
//

public class A29a_main extends JFrame {


    // --------------------------------------

    // Attribute:
    private JPanel northPanel;
    private JLabel label;
    private JTextField textField;

    private JPanel southPanel;
    private JButton okButton;
    private JButton cancelButton;

    // --------------------------------------

    // Konstruktor:
    public A29a_main() {

        // ++++++++++++++++++++++++++

        // Fenstertitel
        // 1. Es soll den Titel Aufgabe29a haben.
        setTitle("Aufgabe29a");

        // ++++++++++++++++++++++++++

        // Nordbereich
        northPanel = new JPanel();

        // 4. Der Nord- und der Sudbereich sollen unterschiedliche Graufarben als Hintergrundfarbe ¨haben.
        northPanel.setBackground(Color.LIGHT_GRAY);

        label = new JLabel("Kontonummer");
        textField = new JTextField(20);


        // 2.a Beschriftung und Textfeld sollen beide dieselbe Schrift mit Schriftgr¨oße 20 haben.
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setFont(new Font("Arial", Font.PLAIN, 20));

        // 2. Es soll im Norden von links nach rechts angeordnet die Beschriftung Kontonummer und ein aktiviertes einzeiliges Textfeld der Breite 20 anzeigen.
        northPanel.add(label);
        northPanel.add(textField);

        add(northPanel, BorderLayout.NORTH);

        // ++++++++++++++++++++++++++

        // Südbereich
        southPanel = new JPanel();

        // 4. Der Nord- und der Sudbereich sollen unterschiedliche Graufarben als Hintergrundfarbe ¨haben.
        southPanel.setBackground(Color.DARK_GRAY);

        okButton = new JButton("Okay");
        cancelButton = new JButton("Abbrechen");

        // 3. Es soll im Suden von links nach rechts angeordnet zwei Schaltfl ¨ ¨achen mit dem Text Okay und Abbrechen anzeigen.
        southPanel.add(okButton);
        southPanel.add(cancelButton);

        add(southPanel, BorderLayout.SOUTH);

        // ++++++++++++++++++++++++++

        // Fenster schließen
        // 5. Durch Klicken auf das Fensterkreuz soll die Anwendung beendet werden.
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ++++++++++++++++++++++++++

        // Fenstergröße und Sichtbarkeit
        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // --------------------------------------

    // main
    public static void main(String[] args) {
        new A29a_main();
    }

    // --------------------------------------
    
}
