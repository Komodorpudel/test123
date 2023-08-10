package uebung07_SUB_4P.A34;


// Implementieren Sie ein Hauptanwendungsfenster MouseHighlighter.java nach folgenden Vorgaben:
    // 1. Das Fenster soll den Titel "Mouse Highlighter" tragen.
    // 2. Das Fenster soll 300 × 300 Pixel groß sein.
    // 3. Im Fenster soll um die Spitze der Maus herum ein Kreis mit Radius 15 Pixel gezeichnet werden, der sich mit der Maus mitbewegt, unabh¨angig davon, ob eine Maustaste gedruckt wird oder nicht. ¨
    // 4. Sorgen Sie dafur, dass der Kreis tats ¨ ¨achlich um die Spitze der Maus gezeichnet wird.
    // 5. Ein Klick auf das Fensterkreuz soll die Anwendung beenden.

// Necessary packages/classes:
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
//

public class MouseHighlighter extends JFrame {

    // --------------------------------------

    // Attribute
    private Point mousePoint;

    // --------------------------------------

    // 
    public MouseHighlighter() {

        // 1. Das Fenster soll den Titel "Mouse Highlighter" tragen.
        setTitle("Mouse Highlighter");

        // 2. Das Fenster soll 300 × 300 Pixel groß sein.
        setSize(300, 300);

        // 5. Ein Klick auf das Fensterkreuz soll die Anwendung beenden.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Im Fenster soll um die Spitze der Maus herum ein Kreis mit Radius 15 Pixel gezeichnet werden, der sich mit der Maus mitbewegt, unabh¨angig davon, ob eine Maustaste gedruckt wird oder nicht. ¨
        // 4. Sorgen Sie dafur, dass der Kreis tats ¨ ¨achlich um die Spitze der Maus gezeichnet wird.
        mousePoint = new Point(0, 0);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mousePoint = e.getPoint();
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                mousePoint = e.getPoint();
                repaint();
            }
        });
    }

    // --------------------------------------

    // paint
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(mousePoint.x - 15, mousePoint.y - 15, 30, 30);
    }

    // --------------------------------------

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MouseHighlighter frame = new MouseHighlighter();
            frame.setVisible(true);
        });
    }

    // --------------------------------------

}
