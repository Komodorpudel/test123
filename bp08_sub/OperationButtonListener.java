package bp08_sub;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OperationButtonListener implements ActionListener {

    // --------------------------------------

    // Attribute:
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JLabel resultLabel;

    // --------------------------------------

    // Konstruktor
    public OperationButtonListener(JLabel resultLabel, JTextField firstNumberField, JTextField secondNumberField) {
        this.resultLabel = resultLabel;
        this.firstNumberField = firstNumberField;
        this.secondNumberField = secondNumberField;
    }

    // --------------------------------------

    // actionPerformed -> Gets automatically called by Swing Framework
    @Override
    public void actionPerformed(ActionEvent e) {

        // Get's the sign on the bottom (e.g. which operation was done)
        String operation = ((JButton) e.getSource()).getText();

        // Try:
        try {

            // Werte der NumberFields in doubles umwandeln
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());

            double result;

            // Führe Operation durch
            // Switch stops checking after one condition is met and just exectues next code, that's why break is needed
            switch (operation) {
                
                case "+":
                    result = num1 + num2;
                    break;

                case "-":
                    result = num1 - num2;
                    break;

                case "*":
                    result = num1 * num2;
                    break;

                case "/":
                    if (num2 == 0) {
                        resultLabel.setText("Fehler (Division durch 0)");
                        return;
                    }
                    result = num1 / num2;
                    break;

                // Wenn nichts provided:
                default:
                    return;
            }

            resultLabel.setText("Ergebnis: " + result);

        }
        
        catch (NumberFormatException ex) {
            resultLabel.setText("Fehler (ungültige Eingabe)");
        }
    }

    // --------------------------------------

}
