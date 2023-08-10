package bp07_sub.c;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
// https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/package-summary.html

public class TextConverterGUI_c extends JFrame {

    // --------------------------------------

    // Attribute:
    private JButton upperCaseButton, lowerCaseButton, reverseButton;
    private JTextField inputField, outputField;
    private JPanel buttonPanel;

    // --------------------------------------

    // Konstruktor:
    public TextConverterGUI_c() {

        // Call JFrame Konstruktor
        super("Text Converter_c");

        // Set parameters
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // 1. Input - text field:
        inputField = new JTextField();

        // 2. Buttons:

        // 2.a. Initialize buttons:
        upperCaseButton = new JButton("Uppercase");
        lowerCaseButton = new JButton("Lowercase");
        reverseButton = new JButton("Reverse");

        // 2.b. Create button panel:
        buttonPanel = new JPanel();
        buttonPanel.add(upperCaseButton);
        buttonPanel.add(lowerCaseButton);
        buttonPanel.add(reverseButton);

        // 2.c. Add action listeners to buttons:
        upperCaseButton.addActionListener(e -> convertToUppercase());
        lowerCaseButton.addActionListener(e -> convertToLowercase());
        reverseButton.addActionListener(e -> reverseText());

        // 3. Output - text field:
        outputField = new JTextField();

        // disable input in output field
        outputField.setEditable(false);  

        // Add components to JFrame
        add(inputField);
        add(buttonPanel);
        add(outputField);

        // Teilaufgabe c:

        // Erzeugen des KeyStroke-Objekts f¨ur "Strg+C"
        KeyStroke copyKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);

        // Binden der Tastenkombination an die Aktion "copy"
        InputMap IM = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        IM.put(copyKeyStroke, "copy");

        // Define the action to be performed when Ctrl+C is pressed
        getRootPane().getActionMap().put("copy", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyToClipboard();
            }
        });

        pack();
        setVisible(true);
    }

    // --------------------------------------

    private void convertToUppercase() {
        String text = inputField.getText();
        outputField.setText(text.toUpperCase());
    }

    // --------------------------------------

    private void convertToLowercase() {
        String text = inputField.getText();
        outputField.setText(text.toLowerCase());
    }

    // --------------------------------------

    private void reverseText() {
        String text = inputField.getText();
        StringBuilder sb = new StringBuilder(text);
        outputField.setText(sb.reverse().toString());
    }

    // --------------------------------------

    // New method to implement copying to clipboard
    private void copyToClipboard() {
        StringSelection stringSelection = new StringSelection(outputField.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    // --------------------------------------

}
