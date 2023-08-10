package bp08_sub;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class TaschenrechnerGUI extends JFrame {

    // --------------------------------------

    // Attribute
    private JLabel firstNumberLabel;
    private JTextField firstNumberField;

    private JLabel secondNumberLabel;
    private JTextField secondNumberField;

    private JButton addButton;
    private JButton subtractButton;

    private JButton multiplyButton;
    private JButton divideButton;

    private JLabel resultLabel;

    // --------------------------------------

    // Konstruktor:
    public TaschenrechnerGUI() {

        // Call JFrame constructor
        super("Taschenrechner");

        // Close Operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        // GridBagConstraints c welche nachfolgend verwendet werden
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // Initialization of Attributes

        // First Row

        // -- First Number Input Field with Description
        firstNumberLabel = new JLabel("Erste Zahl:");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        add(firstNumberLabel, c);

        firstNumberField = new JTextField(10);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        c.gridwidth = 2;
        add(firstNumberField, c);

        // -- Second Number Input Field with Description
        secondNumberLabel = new JLabel("Zweite Zahl:");
        c.gridx = 3;
        c.gridy = 0;
        c.weightx = 0.0;
        c.gridwidth = 1;
        add(secondNumberLabel, c);

        secondNumberField = new JTextField(10);
        c.gridx = 4;
        c.gridy = 0;
        c.weightx = 0.5;
        add(secondNumberField, c);

        // Second Row

        // -- Buttons + and -
        addButton = new JButton("+");
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.5;
        c.gridwidth = 3;
        add(addButton, c);

        subtractButton = new JButton("-");
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 0.5;
        c.gridwidth = 2;
        add(subtractButton, c);

        // Third row

        // -- Buttons * and /
        multiplyButton = new JButton("*");
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.5;
        c.gridwidth = 3;
        add(multiplyButton, c);

        divideButton = new JButton("/");
        c.gridx = 3;
        c.gridy = 2;
        c.weightx = 0.5;
        c.gridwidth = 2;
        add(divideButton, c);

        // Fourth row - Result Label
        resultLabel = new JLabel("Ergebnis: ");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 5;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        add(resultLabel, c);

        // Initialize OperationsButtonListener
        OperationButtonListener listener = new OperationButtonListener(resultLabel, firstNumberField, secondNumberField);

        // Default listener event for a button is to click on it.
        // listener is the listener that will be performed when clicked
        // "addActionListener" will listen to default actionevent of button (click)
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);

        pack();
        // If not used, I need to manually resize windows
    }
}
