package B_Uebung.uebung07_sub_4P.A31_A32;


// Implementieren Sie ein Hauptanwendungsfenster LabelCreator.java nach folgenden Vorgaben:
    // 1. Das Fenster soll den Titel "Label Creator" tragen.
    // 2. Das Fenster soll 200 × 200 Pixel groß sein.
    // 3. Beim Klicken des Fensterkreuzes soll das Fenster geschlossen werden.
    // 4. Im Zentrum des Fensters soll ein zu Beginn leeres Panel sein.
    // 5. im Suden des Fensters soll ein Button mit dem Text ¨ "Add new label" sein.

    // 6. Immer wenn der Button gedruckt wird soll ein neues Label mit der aktuellen Uhrzeit ¨im Format HH:MM:SS im Panel des Fensters auftauchen, wobei der Text eine zuf¨allige RGB-Farbe haben soll.
    // 7. Implementieren Sie eine eigene Klasse LabelCreatorListener fur die Umsetzung ¨der Ereignisbehandlung, an deren Konstruktur Sie das Panel des Fensters ubergeben ¨k¨onnen.
    // Hinweis: Damit die Label nach der Erzeugung auch wirklich angezeigt werden, muss das Panel, welches die Labels beinhaltet, neu validiert werden.Verwenden Sie dazu die revalidate()-Methode des Panels.

// Necessary packages/classes:
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
//

public class LabelCreatorListener implements ActionListener {

    // --------------------------------------

    // Attribute
    private JPanel panel;
    private Random random;

    // --------------------------------------

    // Konstruktor
    public LabelCreatorListener(JPanel panel) {
        this.panel = panel;
        this.random = new Random();
    }

    // --------------------------------------

    // actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {

        // 6. Immer wenn der Button gedruckt wird soll ein neues Label mit der aktuellen Uhrzeit ¨im Format HH:MM:SS im Panel des Fensters auftauchen, .... 
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String currentTime = formatter.format(new Date());

        // ... wobei der Text eine zuf¨allige RGB-Farbe haben soll.
        JLabel timeLabel = new JLabel(currentTime);
        timeLabel.setForeground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

        // Hinzufügen des Labels zum Panel und aktualisieren des Panels
        panel.add(timeLabel);
        panel.repaint();

        // Hinweis: Damit die Label nach der Erzeugung auch wirklich angezeigt werden, muss das Panel, welches die Labels beinhaltet, neu validiert werden.Verwenden Sie dazu die revalidate()-Methode des Panels.
        panel.revalidate();
        
    }

    // --------------------------------------
}
