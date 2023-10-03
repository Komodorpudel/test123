package B_Uebung.uebung07_sub_4P.A31_A32_neu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelCreatorListener_neu implements ActionListener {

    private JPanel receivedPanel;
    Random myRandom = new Random();

    // Konstruktor
    public LabelCreatorListener_neu (JPanel centerPanel){

        receivedPanel = centerPanel;
        
    }

    // actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {

        // Time
        LocalTime now = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);


        // Create new label
        JLabel temp = new JLabel(now.format(DateTimeFormatter.ISO_LOCAL_TIME));
        temp.setForeground(new Color(myRandom.nextInt(256), myRandom.nextInt(256), myRandom.nextInt(256)));

        receivedPanel.add(temp);
        receivedPanel.revalidate();

    }
    
}
