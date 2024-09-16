public class GarageMain {
    public static void main(String[] args) {
        int totalCarSpaceCount = 0;
        new Garage();
        totalCarSpaceCount += 10;
        Garage g2 = null;
        Garage g3 = null;
        try {
            g2 = new Garage(-1);
        } catch (GarageException e) {
            System.out.println("Creating a garage with negative maxCarSpaces failed successfully: " + e.getMessage());
        }
        if (g2 != null) {
            System.err.println("Could create a garage with negative maxCarSpace, exiting...");
            System.exit(-1);
        }
        try {
            g3 = new Garage(15);
            g2 = new Garage(0);
        } catch (GarageException e) {
            System.out.println("Creating a garage with maxCarSpaces = 0 failed successfully: " + e.getMessage());
        }
        if (g2 != null) {
            System.err.println("Could create a garage with maxCarSpace = 0, exiting...");
            System.exit(-1);
        }
        totalCarSpaceCount += 15;
        Garage g4 = null;
        try {
            g2 = new Garage(17, -1);
        } catch (GarageException e) {
            System.out.println("Creating a garage with negative freeCarSpaces failed successfully: " + e.getMessage());
        }
        if (g2 != null) {
            System.err.println("Could create a garage with negative freeCarSpaces, exiting...");
            System.exit(-1);
        }
        try {
            g4 = new Garage(17, 0);
            g2 = new Garage(17, 18);
        } catch (GarageException e) {
            System.out.println("Creating a garage with freeCarSpaces > maxCarSpaces failed successfully: " + e.getMessage());
        }
        if (g2 != null) {
            System.err.println("Could create a garage with freeCarSpaces > maxCarSpaces, exiting...");
            System.exit(-1);
        }
        totalCarSpaceCount += 17;
        try {
            g3.incFreeCarSpaces();
            System.err.println("Could increase freeCarSpaces over maxCarSpaces, exiting...");
            System.exit(-1);
        } catch (GarageException e) {
            System.out.println("Incrementing freeCarSpaces when all are free failed successfully: " + e.getMessage());
        }
        try {
            g4.decFreeCarSpaces();
            System.err.println("Could decrease freeCarSpaces below 0, exiting...");
            System.exit(-1);
        } catch (GarageException e) {
            System.out.println("Decrementing freeCarSpaces when all are taken failed successfully: " + e.getMessage());
        }

        if (Garage.getTotalCarSpaces() != totalCarSpaceCount) {
            System.err.println("totalCarSpaces is " + Garage.getTotalCarSpaces() + " but should be 42.\n" +
                    "Check your constructor error cases");
            System.exit(-1);
        }
        if (Garage.calculateTotalCarSpacesValue() != totalCarSpaceCount * 300.50) {
            System.err.println("totalCarSpaceValue is " + Garage.calculateTotalCarSpacesValue() + " but should be " + 42 * 300.50 + ".");
            System.exit(-1);
        }
        System.out.println("Passed all checks");
    }
}
