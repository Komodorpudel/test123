package bp03_sub;

public class GeoCalculator {
    
    // --------------------------------------

    // calculateTotalArea
    public static double calculateTotalArea(Shape[] shapes) {
        double totalArea = 0;

        for (Shape shape : shapes) {
        totalArea = totalArea + shape.getArea();
        }
        return totalArea;
    }

    // --------------------------------------

    // calculateTotalPerimeter
    public static double calculateTotalPerimeter(Shape[] shapes) {
        double totalPerimeter = 0;

        for (Shape shape : shapes) {
        totalPerimeter = totalPerimeter + shape.getPerimeter();
        }
        return totalPerimeter;
    }

    // --------------------------------------

    //getAllShapes
    public static StringBuilder getAllShapes(Shape[] shapes) {
        StringBuilder builder = new StringBuilder();

        for (Shape shape : shapes) {
            builder.append("Shape: ")
                    .append(shape.getClass().getSimpleName())
                    .append(", ")
                    .append("Area: ")
                    .append(shape.getArea())
                    .append(", ")
                    .append("Perimeter: ")
                    .append(shape.getPerimeter())
                    .append("\n");
        }
        return builder;
    }

}
