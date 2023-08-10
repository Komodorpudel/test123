package bp03_sub;

//Rectangle
public class Rectangle implements Shape { //Rectangle muss Methoden von Shape implementieren
    // Privates Attribut length und width
    private double length;
    private double width;

    // Konstruktor (immer gleicher Name wie Class)
    public Rectangle (double length, double width) {
        this.length = length;
        this.width = width;
    }

    //getArea
    public double getArea() {
        return length * width;
    }

    //getPerimeter
    public double getPerimeter(){
        return 2 * length + 2 * width;
    }
}