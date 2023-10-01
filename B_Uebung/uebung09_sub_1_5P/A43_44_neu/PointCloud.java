package B_Uebung.uebung09_sub_1_5P.A43_44_neu;

import java.awt.Point;
import java.util.ArrayList;

public class PointCloud {

    double limit = 10;
    ArrayList <Point> points = new ArrayList<>();

    public static void main(String [] args){

        PointCloud myPointCloud = new PointCloud();
        Point p = new Point(3, 4);
        myPointCloud.addPoint(p);

        myPointCloud.points.forEach(n -> System.out.println(n));
        
    }


    public void addPoint(Point p){

        double x = p.getX();
        double x2 = Math.pow(x, 2);

        double y = p.getY();

        double y2 = Math.pow(y, 2);

        double radius = Math.sqrt(x2 + y2);

        if(radius > this.limit){
            throw new IllegalArgumentException("Point to far away from cloud");
        }

        this.points.add(p);
    }
    
}
