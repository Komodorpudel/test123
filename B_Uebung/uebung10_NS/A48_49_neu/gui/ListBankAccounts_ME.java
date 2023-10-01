package B_Uebung.uebung10_NS.A48_49_neu.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import B_Uebung.uebung10_NS.A48_49_neu.data.BankAccount;
import B_Uebung.uebung10_NS.A48_49_neu.data.BankAccountContainer_ME;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

public class ListBankAccounts_ME extends JDialog implements ActionListener, PropertyChangeListener {

    // Attribute
    private BankAccountContainer_ME bankAccountContainer;
    private JList<BankAccount> bankAccountList;

    // Konstruktor
    public ListBankAccounts_ME(BankGUI parent) {

        super(parent, "Show all bank accounts", false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        JLabel lblAllBankAccounts = new JLabel("All bank accounts: ");
        add(lblAllBankAccounts, BorderLayout.NORTH);

        bankAccountList = new JList<>();
        add(bankAccountList, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        add(buttons, BorderLayout.SOUTH);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        buttons.add(cancel);

        JButton delete = new JButton("Delete bank account");
        delete.addActionListener(this);
        buttons.add(delete);

        JButton edit = new JButton("Edit bank account");
        edit.addActionListener(this);
        buttons.add(edit);

        setLocation(parent.getLocation().x + 200, parent.getLocation().y + 200);

        // ++++++++++++++++++++

        // Instance holen
        bankAccountContainer = BankAccountContainer_ME.instance();
        bankAccountContainer.addPropertyChangeListener(this);

        for (BankAccount b : bankAccountContainer) {
            b.addPropertyChangeListener(this);
        }

        // ++++++++++++++++++++ 

        // Finally
        updateList();
        pack();
        setVisible(true);

    }

    //to-do: propertyChange
    public void propertyChange(PropertyChangeEvent e) {
        updateList();

        if (e.getPropertyName().equals("BankAccounts")) {
            BankAccount temp = (BankAccount) e.getNewValue();

            // Falls neuer Wert kommt:
            if (temp != null){
                temp.addPropertyChangeListener(this);
            }

            // Falls vorhandener Wert entfernt wird:
            else {
                temp = (BankAccount) e.getOldValue();
                temp.removePropertyChangeListener(this);
            }
        }
        
    }

    private void updateList() {
        Vector<BankAccount> v = new Vector<BankAccount>();
        for (BankAccount b : bankAccountContainer)
            v.add(b);
        bankAccountList.setListData(v);
        pack();
    }

    // ++++++++++++++++++++++++++++++++

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Delete bank account")) {
            onDelete();
        }
        
        else if (e.getActionCommand().equals("Cancel")) {
            onCancel();
        }
        
        else if (e.getActionCommand().equals("Edit bank account")) {
            onEdit();
        }
    }

    // To-do: onDelete
    private void onDelete() {
        BankAccount subject = bankAccountList.getSelectedValue();

        if (subject != null){
            subject.removePropertyChangeListener(this);
            bankAccountContainer.unlinkBankAccount(subject);
        }

        else {
            JOptionPane.showMessageDialog(null, "No bank account selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // To-do: onEdit
    private void onEdit() {
        BankAccount subject = bankAccountList.getSelectedValue();

        if (subject != null) {
            new ChangeBankAccount_ME(this, subject);
        }

        else{
            JOptionPane.showMessageDialog(null, "No bank account slected", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    // onCancel
    private void onCancel() {
        dispose();
    }
}
