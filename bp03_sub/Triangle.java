package bp03_sub;

// Triangle
public class Triangle implements Shape { //Rectangle muss Methoden von Shape implementieren
    // Privates Attribut 
    private double side1;
    private double side2;
    private double side3;

    // Konstruktor (immer gleicher Name wie Class)
    public Triangle (double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //getArea
    public double getArea() {
        // Heron's forumla
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    //getPerimeter
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
}