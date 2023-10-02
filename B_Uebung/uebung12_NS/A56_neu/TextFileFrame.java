package B_Uebung.uebung12_NS.A56_neu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextFileFrame extends JFrame implements ActionListener {

    // Attribute
    private String filename = "output.txt";
    private PrintWriter writer;
    private JTextField textField;


    // Konstruktor
    public TextFileFrame() {
        super("Text file frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Textfeld zum eingeben
        textField = new JTextField(40);
        add(textField, BorderLayout.WEST);
        
        // Button, bei dessem druck die datei beschrieben wird
        JButton writeButton = new JButton("Write to file");
        writeButton.addActionListener(this);
        add(writeButton, BorderLayout.EAST);


       // TO-DO
       // writer initialisieren
        try {
            writer = new PrintWriter(filename);
        }

        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        
        addWindowListener(new WindowAdapter() {

            // writer schliessen wenn das Fenster geschlossen wird
            @Override
            public void windowClosing (WindowEvent e) {
                writer.close();
            }
            
        });

        // Finally
        pack();
        setVisible(true);
    }

    // ---------

    // Action Performed
    @Override
    public void actionPerformed(ActionEvent e) {

        /* TO-DO
        *   Inhalt von textField in neuer Zeile in Datei schreiben */
        writer.println(textField.getText());
    }

    public static void main(String[] args) {
        new TextFileFrame();
    }
}
