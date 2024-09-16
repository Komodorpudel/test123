package data;

import java.util.ArrayList;
import java.util.Iterator;

public class CarContainer implements Iterable<Car> {
    private ArrayList<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public void remove(Car car) {
        cars.remove(car);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
