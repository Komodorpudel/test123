import data.Car;
import data.CarContainer;
import data.CarException;
import gui.CarWindow;

public class CarMain {
    public static void main(String[] args) {
        CarContainer con = new CarContainer();
        try {
            con.add(new Car("AB-CD-12", 4));
            con.add(new Car("EF-GH-34", 8));
            con.add(new Car("XY-ZZ-99", 2));
        } catch (CarException e) {
            System.out.println(e.getMessage());
        }
        new CarWindow(con);
    }
}
