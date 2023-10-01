package B_Uebung.uebung10_NS.A48_49_neu.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import B_Uebung.uebung10_NS.A48_49_neu.data.BankAccount;
import B_Uebung.uebung10_NS.A48_49_neu.data.BankAccountContainer_ME;
import B_Uebung.uebung10_NS.A48_49_neu.data.IllegalBankingException;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BankGUI extends JFrame implements ActionListener {

    // Attribute
    private BankAccountContainer_ME bankAccountContainer = BankAccountContainer_ME.instance();


    // Konstruktor
    public BankGUI() {
        super("Bank Manager");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        JPanel panelSouth = new JPanel();

        JButton btnShowAccounts = new JButton("Show all bank accounts");
        btnShowAccounts.addActionListener(this);
        panelSouth.add(btnShowAccounts);

        JButton btnBalanceByHolder = new JButton("Calculate total balance for a holder");
        btnBalanceByHolder.addActionListener(this);
        panelSouth.add(btnBalanceByHolder);

        JButton btnClose = new JButton("Close application");
        btnClose.addActionListener(this);
        panelSouth.add(btnClose);

        this.add(panelSouth, BorderLayout.SOUTH);

        setSize(900, 200);
        setVisible(true);
    }

    // actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Show all bank accounts")) {
            onList();
        }
        
        else if (e.getActionCommand().equals("Calculate total balance for a holder")) {
            onBalanceByHolder();
        }
        
        else if (e.getActionCommand().equals("Close application")) {
            onClose();
        }
    }


    // onList
    private void onList() {
        new ListBankAccounts_ME(this);
    }

    // onBalancebyHolder
    private void onBalanceByHolder() {
        String name = JOptionPane.showInputDialog(this, "Enter holder name");
        double sum = 0;
        for (BankAccount b : bankAccountContainer) {
            if (b.getAccountHolderName().equals(name)) {
                sum += b.getBalance();
            }

        }
        JOptionPane.showMessageDialog(this, name + " holds " + sum + "euros in total");
    }

    // onClose
    private void onClose() {
        dispose();
        System.exit(0);
    }

    // main zum testen
    public static void main(String[] args) {

        // Container holen
        BankAccountContainer_ME container = BankAccountContainer_ME.instance();
        
        try {
            BankAccount temp = new BankAccount("Dagobert Duck", "ENTENHAUSEN1");
            temp.addBalance(23561.65);
            container.linkBankAccount(temp);

            temp = new BankAccount("Dagobert Duck", "ENTENHAUSEN2");
            temp.addBalance(336.09);
            container.linkBankAccount(temp);

            temp = new BankAccount("Dagobert Duck", "ENTENHAUSEN3");
            temp.addBalance(123226.09);
            container.linkBankAccount(temp);

            temp = new BankAccount("Donald Duck", "ENTENHAUSEN4");
            temp.addBalance(- 3461.65);
            container.linkBankAccount(temp);

            temp = new BankAccount("Donald Duck", "PHANTOMIAS12");
            temp.addBalance(44239.50);
            container.linkBankAccount(temp);

            temp = new BankAccount("Klaas Klever", "ENTENHAUSEN5");
            temp.addBalance(546753.12);
            container.linkBankAccount(temp);

        }
        
        catch (IllegalBankingException e) {
            throw new RuntimeException(e);
        }
        new BankGUI();
    }
}
