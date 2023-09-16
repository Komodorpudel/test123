package bp03_sub;

public class Main {
    public static void main(String[] args) {
//          Schritt 1: Erstellen der Formen
            Shape[] shapes = new Shape[3]; // Creates array length 3
            shapes[0] = new Circle(5);
            shapes[1] = new Rectangle(3, 4);
            shapes[2] = new Triangle(3, 4, 5);

//          Schritt 2: Berechnung der Gesamtfläche aller Formen
            double totalArea = GeoCalculator.calculateTotalArea(shapes);
            System.out.println("Total area: " + totalArea);

//          Schritt 3: Berechnung des Gesamtumfangs aller Formen
            double totalPerimeter = GeoCalculator.calculateTotalPerimeter(shapes);
            System.out.println("Total perimeter: " + totalPerimeter);

//          Schritt 4: Konkatenierte Ausgabe
            StringBuilder completeShapeString = GeoCalculator.getAllShapes(shapes);
            System.out.println(completeShapeString);
    }
}