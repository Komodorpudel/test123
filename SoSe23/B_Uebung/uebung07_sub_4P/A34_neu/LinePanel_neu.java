package SoSe23.B_Uebung.uebung07_sub_4P.A34_neu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LinePanel_neu extends JPanel {

    private Point previewPoint;

    // problem, ein einfaches Array hat eine fixe Länge
    private final ArrayList <Point> points = new ArrayList<>();

    public LinePanel_neu(){
        super(); // No this. because the object does not exist yet
        // setSize(300, 300);
        this.setPreferredSize(new Dimension(300,300));

        this.addMouseListener (new MouseAdapter(){
            @Override
            public void mouseReleased (MouseEvent e) {
                previewPoint = e.getPoint();
                LinePanel_neu.this.points.add(previewPoint);
                LinePanel_neu.this.repaint();  
            }

        });

        // ----

        this.addMouseMotionListener (new MouseMotionAdapter(){
            @Override
            public void mouseDragged (MouseEvent e){
                previewPoint = e.getPoint();
                repaint();
            }
        });

        this.setSize(300,300);

    }

    @Override
    public void paint (Graphics g){

        // Nur wenn nicht leer, dann:
        if(!points.isEmpty()){
            Point previousPoint = points.get(0);

            for(int i = 1; i <points.size(); i++){
                g.drawLine(previousPoint.x, previousPoint.y, points.get(i).x, points.get(i).y);

                previousPoint = points.get(i); // previous point auf aktuellen Punkt setzen
            }

            g.drawLine(previousPoint.x, previousPoint.y, previewPoint.x, previewPoint.y);

        }

    }
/* 
    @Override
    public void paintComponent (Graphics g) {
        super.paintComponents(g);

        // Nur wenn nicht leer, dann:
        if(!points.isEmpty()){
            Point previousPoint = points.get(0);

            // Wenn nur ein Punkt drin ist, dann macht er das garnicht
            for(int i = 1; i <points.size(); i++){
                g.drawLine(previousPoint.x, previousPoint.y, points.get(i).x, points.get(i).y);

                previousPoint = points.get(i);
            }

            // Damit zeichnen wir die Vorschaulinie
            g.drawLine(previousPoint.x, previousPoint.y, previewPoint.x, previewPoint.y);

        }

    } */
    
}

        /* In Swing, you typically override `paintComponent(Graphics g)` instead of `paint(Graphics g)` for a few reasons:

        1. **Layering of Painting**: The `paint(Graphics g)` method in `JComponent` (from which `JPanel` is derived) is responsible for painting the component
        and its borders, children, etc. It does this by calling three methods in succession: 
        - `paintComponent(Graphics g)`
        - `paintBorder(Graphics g)`
        - `paintChildren(Graphics g)`
        
        By overriding just `paintComponent(Graphics g)`, you ensure that only the actual component gets custom painting while still allowing
         the component's border and children (if any) to be painted normally.

        2. **Double Buffering**: Swing components use double buffering to eliminate flicker. The `paintComponent` method draws the component's
         appearance into an offscreen buffer, then that buffer is quickly copied to the screen. If you override `paint` directly and don't manage
          the buffering yourself, you'll lose this benefit and might observe flicker when the component updates.

        3. **Clipping and Efficiency**: When `paintComponent` is called, Swing has set the clip in the `Graphics` object to be the minimal
         area that requires repainting, making your custom painting code more efficient. If you override `paint`, you'll be responsible for setting up this clipping area yourself.

        4. **Keeping Swing's Painting Contract**: By sticking to the conventions of Swing's painting architecture,
         you ensure that your custom painting integrates smoothly with the rest of the system. This can prevent unexpected behavior or bugs.

        In summary, while you can override `paint`, it's typically better to override `paintComponent` when dealing with Swing components to ensure smooth and proper rendering behavior. */