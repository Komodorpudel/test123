package bp07_sub.a_b;

import javax.swing.*;
import java.awt.*;

public class TextConverterGUI extends JFrame {

    // --------------------------------------

    // Attribute:
    private JButton upperCaseButton, lowerCaseButton, reverseButton;
    private JTextField inputField, outputField;
    private JPanel buttonPanel;

    // --------------------------------------

    // Konstruktor:
    public TextConverterGUI() {

        // Call JFrame Konstruktor
        super("Text Converter");

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
        outputField.setEditable(false);  // disable input in output field

        // Add components to JFrame
        add(inputField);
        add(buttonPanel);
        add(outputField);

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

}
