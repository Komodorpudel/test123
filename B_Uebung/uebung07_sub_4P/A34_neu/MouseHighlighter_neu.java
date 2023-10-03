package B_Uebung.uebung07_sub_4P.A34_neu;

import java.awt.Graphics;
// import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class MouseHighlighter_neu extends JFrame {

    private int x;
    private int y;

    // private Point();

    public MouseHighlighter_neu(){

        super ("Mouse Highlighter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseMotionListener(new MouseMotionAdapter(){

            @Override
            public void mouseMoved (MouseEvent e) {

                x = e.getX();
                y = e.getY();

                repaint();
                
            }

            @Override
            public void mouseDragged (MouseEvent e) {

                x = e.getX();
                y = e.getY();

                repaint();

            }

        });

        // Finally
        setSize(300, 300);
        setVisible(true);

    }

    // I cannot use paintComponent here because it is designed to be used with lightweight JComponent objects like JPanels

    /*  public void paintComponents (Graphics g) {
        super.paintComponents(g); // entfernt das vorher gezeichnete
        g.drawOval(x - 15, y - 15,  30, 30);
    } */

    public void paint (Graphics g) {
        super.paint(g); // entfernt das vorher gezeichnete
        g.drawOval(x - 15, y - 15,  30, 30);
    }

    public static void main (String[] args) {
        new MouseHighlighter_neu();
    }
    
}
