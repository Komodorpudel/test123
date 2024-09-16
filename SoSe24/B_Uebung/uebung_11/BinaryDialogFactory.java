import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinaryDialogFactory extends JFrame implements ActionListener {
    private static final String FILENAME = "binaryFrame";

    private final JButton create;
    private final JButton save;
    private final JButton load;

    private BinaryDialog binaryDialog = null;

    public BinaryDialogFactory() {
        super("Binary Frame Factory");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        create = new JButton("Create New");
        create.addActionListener(this);
        add(create, BorderLayout.WEST);
        save = new JButton("Save");
        save.addActionListener(this);
        add(save, BorderLayout.CENTER);
        load = new JButton("Load");
        load.addActionListener(this);
        add(load, BorderLayout.EAST);

        pack();
        setVisible(true);
    }

    private void onCreate() {
        if (binaryDialog != null) {
            binaryDialog.dispose();
        }
        binaryDialog = new BinaryDialog(this);
    }

    private void onSave() {
        // TODO: Implement serialization of the window

    }

    private void onLoad() {
        // TODO: Implement deserialization of the window

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(create)) {
            onCreate();
        } else if (e.getSource().equals(save)) {
            if (binaryDialog != null)
                onSave();
        } else if (e.getSource().equals(load)) {
            onLoad();
        }
    }

    public static void main(String[] args) {
        new BinaryDialogFactory();
    }
}
