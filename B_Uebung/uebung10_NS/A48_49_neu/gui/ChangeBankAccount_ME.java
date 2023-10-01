package B_Uebung.uebung10_NS.A48_49_neu.gui;
import B_Uebung.uebung10_NS.A48_49_neu.data.BankAccount;
import B_Uebung.uebung10_NS.A48_49_neu.data.BankAccountContainer_ME;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@SuppressWarnings("serial")
public class ChangeBankAccount_ME extends JDialog implements ActionListener, PropertyChangeListener {


	// Attribute
    private BankAccount subject;
    private BankAccountContainer_ME container;

    private JTextField holderTextfield;
    private JTextField balanceTextField;
	private JTextField accountNumberTextfield;

	// Konstruktor
    public ChangeBankAccount_ME(ListBankAccounts_ME parent, BankAccount subject) {

		super(parent, "Change Employee" + subject.getAccountNumber(), false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		container = BankAccountContainer_ME.instance();
		container.addPropertyChangeListener(this);

		for (BankAccount b : container) {
			b.addPropertyChangeListener(this);
		}

		this.subject = subject;

		this.setLayout(new GridLayout(0, 1));

		JPanel oben = new JPanel();
		add(oben);
		oben.setLayout(new BorderLayout());

		JPanel p = new JPanel();
		oben.add(p, BorderLayout.NORTH);
		
		JLabel accountNumberLabel = new JLabel("Account number: ");
		accountNumberTextfield = new JTextField(12);
		accountNumberTextfield.setEnabled(false);
		p.add(accountNumberLabel);
		p.add(accountNumberTextfield);

		JLabel holderLabel = new JLabel("Account holder: ");
		holderTextfield = new JTextField(20);
		p.add(holderLabel);
		p.add(holderTextfield);

		JLabel balanceLabel = new JLabel("Add Balance: ");
		balanceTextField = new JTextField(20);
		balanceTextField.setEnabled(true);
		p.add(balanceLabel);
		p.add(balanceTextField);

		JPanel t = new JPanel();
		oben.add(t, BorderLayout.CENTER);

		JButton ok = new JButton("OK");
		ok.addActionListener(this);
		t.add(ok);

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		t.add(cancel);

		setLocation(parent.getLocation().x + 200, parent.getLocation().y + 200);
		load();
		pack();
		setVisible(true);
    }

	// propertyChange
    @Override
    public void propertyChange(PropertyChangeEvent e) {
	if (e.getPropertyName().equals("bank account")) {
	    BankAccount b = (BankAccount) e.getNewValue();
	    if (b != null)
			b.addPropertyChangeListener(this);
	    else {
			b = (BankAccount) e.getOldValue();
			b.removePropertyChangeListener(this);
		if (b.equals(subject))
		    dispose();
	    }
	}

    }

	// To-do: Save
    private void save() {

		try{
			this.subject.addBalance(Double.parseDouble(balanceTextField.getText()));
			dispose();
		}

		catch (IllegalArgumentException e) {
			load();
			JOptionPane.showMessageDialog(null, "Please input a valid account holder name and a valid balance to add." + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
    }

	// actionPerformed
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("OK")) {
			onOk();
		} else if (e.getActionCommand().equals("Cancel")) {
			onCancel();
		}
    }

	// onOk
    private void onOk() {
	save();
    }

	// onCancel
    private void onCancel() {
	dispose();
    }

	// load
    private void load() {
		if (subject != null) {
			accountNumberTextfield.setText(subject.getAccountNumber());
			holderTextfield.setText(subject.getAccountHolderName());
			balanceTextField.setText("0");
		} else {
			JOptionPane.showMessageDialog(null, "No bank account selected", "Error", JOptionPane.ERROR_MESSAGE);
		}
    }
}