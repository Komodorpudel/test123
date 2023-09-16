package bp03_sub;

// Circle
public class Circle implements Shape { //Circle muss Methoden von Shape implementieren
    // Privates Attribut radius
    private double radius;

    // Konstruktor (immer gleicher name wie Class)
    public Circle (double radius) {
        this.radius = radius;
    }

    //getArea
    public double getArea() {
        return Math.PI * radius * radius;
    }

    //getPerimeter
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}