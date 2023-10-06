package D_Klausur.SoSe23.Aufgabe_06;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintPanel extends JPanel {

    private int x = 0;
    private int y = 0;

    public PaintPanel() {

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e){

                x = e.getX();
                y = e.getY();

                repaint();

            }
        });

    }

    public void paint (Graphics g){

        g.drawLine(x,y,x,y+60); // strich nach unten
        g.drawLine(x,y, x+30,y); // nach rechts
        g.drawLine(x,y+30,x+30,y+30);

    }
    
}
