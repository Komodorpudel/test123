import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class BinaryDialog extends JDialog implements ActionListener {

    private final ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
    private final ArrayList<JTextField> binaryFields = new ArrayList<>();


    int n = 16;
    int encoding = 0;
    JTextField numberField;
    JComboBox<Integer> numberSelector;
    JPanel boxPanel;

    public BinaryDialog(JFrame parent) {
        super(parent, "Binary Frame", false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        numberField = new JTextField("" + encoding);
        numberField.setEditable(false);
        add(numberField, BorderLayout.NORTH);
        boxPanel = new JPanel();
        boxPanel.setLayout(new GridLayout(0, n));
        for (int i = 0; i < n; i++) {
            JTextField field = new JTextField("0");
            field.setEditable(false);
            binaryFields.add(field);
            boxPanel.add(field);
        }
        for (int i = 0; i < n; i++) {
            JCheckBox box = new JCheckBox();
            box.addActionListener(this);
            checkBoxes.add(box);
            boxPanel.add(box);
        }
        add(boxPanel, BorderLayout.CENTER);

        numberSelector = new JComboBox<>();
        numberSelector.addItem(8);
        numberSelector.addItem(16);
        numberSelector.addItem(32);
        numberSelector.addItem(64);
        numberSelector.setSelectedIndex(1);
        numberSelector.addActionListener(this);
        add(numberSelector, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    private void updateBoxes() {
        int newNumber = (Integer) numberSelector.getSelectedItem();
        boolean[] isSelected = new boolean[n];
        for (int i = 0; i < n; i++) {
            isSelected[i] = checkBoxes.get(i).isSelected();
        }
        checkBoxes.clear();
        binaryFields.clear();
        JPanel temp = new JPanel();
        temp.setLayout(new GridLayout(0, newNumber));
        for (int i = 0; i < newNumber; i++) {
            JTextField field = new JTextField("0");
            field.setEditable(false);
            binaryFields.add(field);
            temp.add(field);
        }
        for (int i = 0; i < newNumber; i++) {
            JCheckBox box = new JCheckBox();
            checkBoxes.add(box);
            temp.add(box);
        }
        if (newNumber < n) {
            for (int i = 0; i < newNumber; i++) {
                if (isSelected[n - newNumber + i]) {
                    binaryFields.get(i).setText("1");
                    checkBoxes.get(i).setSelected(true);
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (isSelected[i]) {
                    binaryFields.get(newNumber - n + i).setText("1");
                    checkBoxes.get(newNumber - n + i).setSelected(true);
                }
            }
        }

        for (int i = 0; i < newNumber; i++) {
            checkBoxes.get(i).addActionListener(this);
        }
        n = newNumber;
        remove(boxPanel);
        boxPanel = temp;
        add(boxPanel, BorderLayout.CENTER);
        pack();
        updateEncoding();
    }

    private void updateEncoding() {
        encoding = 0;
        for (int i = n - 1; i > 0; i--) {
            if (checkBoxes.get(i).isSelected()) {
                encoding += 1 << n - 1 - i;
            }
        }
        if (checkBoxes.get(0).isSelected()) {
            encoding -= 1 << n - 1;
        }
        numberField.setText("" + encoding);
    }

    private void onCheckBox(JCheckBox box) {
        int index = checkBoxes.indexOf(box);
        if (box.isSelected()) {
            binaryFields.get(index).setText("1");
        } else {
            binaryFields.get(index).setText("0");
        }
        updateEncoding();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(numberSelector)) {
            if ((Integer) numberSelector.getSelectedItem() != n) {
                updateBoxes();
            }
        } else {
            onCheckBox((JCheckBox) e.getSource());
        }
    }

    public void copyFromBinaryDialog(BinaryDialog dialog) {
        numberSelector.setSelectedItem(dialog.numberSelector.getSelectedItem());
        for (int i = 0; i < n; i++) {
            if (dialog.checkBoxes.get(i).isSelected()) {
                binaryFields.get(i).setText("1");
                checkBoxes.get(i).setSelected(true);
            }
        }
        updateEncoding();
    }
}
