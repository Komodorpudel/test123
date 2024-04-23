package SoSe23.B_Uebung.uebung06_sub_4P.A29;


// Necessary packages/classes:
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//

public class A29b_main extends JFrame {

    // --------------------------------------

    // Attribute:
    private JPanel inputPanel;
    private JTextField inputField;

    private JPanel buttonPanel;
    private JButton[] numberButtons;
    private JButton clearButton;
    private JButton okayButton;

    // --------------------------------------

    // Konstruktor:
    public A29b_main() {

        // ++++++++++++++++++++++++++

        // Fenstertitel
        setTitle("A29b");

        // ++++++++++++++++++++++++++

        // A. Weißes Feld für Input
        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));
        inputField.setEditable(false);
        inputPanel.add(inputField, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);

        // ++++++++++++++++++++++++++

        // B. Buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3));

        numberButtons = new JButton[10]; // 0 to 9

        // Add buttons 7, 8, 9
        for (int i = 7; i <= 9; i = i + 1) {
            numberButtons[i-1] = createNumberButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i-1]);
        }

        // Add buttons 4, 5, 6
        for (int i = 4; i <= 6; i = i + 1) {
            numberButtons[i-1] = createNumberButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i-1]);
        }

        // Add buttons 1, 2, 3
        for (int i = 1; i <= 3; i = i + 1) {
            numberButtons[i-1] = createNumberButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i-1]);
        }

        // Add 0, Clear, Okay buttons
        numberButtons[0] = createNumberButton("0");
        buttonPanel.add(numberButtons[0]);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });
        buttonPanel.add(clearButton);

        okayButton = new JButton("Okay");
        buttonPanel.add(okayButton);

        add(buttonPanel, BorderLayout.CENTER);

        // ++++++++++++++++++++++++++

        // Fenster schließen
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ++++++++++++++++++++++++++

        // Fenstergröße und Sichtbarkeit
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // --------------------------------------

    private JButton createNumberButton(String text) {

        JButton button = new JButton(text);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText(inputField.getText() + text);
            }
        });
        return button;
    }

    // --------------------------------------

    public static void main(String[] args) {
        new A29b_main();
    }

    // --------------------------------------

}
