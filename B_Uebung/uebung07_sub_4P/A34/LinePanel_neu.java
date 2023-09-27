package B_Uebung.uebung07_sub_4P.A34;

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
        super();
        // setSize(300, 300);
        setPreferredSize(new Dimension(300,300));

        addMouseListener (new MouseAdapter(){
            @Override
            public void mouseReleased (MouseEvent e) {
                previewPoint = e.getPoint();
                points.add(previewPoint);
                repaint();  
            }

        });

        // ----

        addMouseMotionListener (new MouseMotionAdapter(){
            @Override
            public void mouseDragged (MouseEvent e){
                previewPoint = e.getPoint();
                repaint();
            }
        });

        setSize(300,300);

    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponents(g);

        // Nur wenn nicht leer, dann:
        if(!points.isEmpty()){
            Point previousPoint = points.get(0);

            for(int i = 1; i <points.size(); i++){
                g.drawLine(previousPoint.x, previousPoint.y, points.get(i).x, points.get(i).y);

                previousPoint = points.get(i);
            }

            g.drawLine(previousPoint.x, previousPoint.y, previewPoint.x, previewPoint.y);

        }
    }
    
}
