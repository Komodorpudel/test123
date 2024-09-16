package data;

public class Car {

    private int numberOfSeats;
    private String licensePlate;

    public Car(String licensePlate, int numberOfSeats) throws CarException {
        setLicensePlate(licensePlate);
        setNumberOfSeats(numberOfSeats);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    private static boolean checkNumberOfSeats(int numberOfSeats) {
        return numberOfSeats > 0;
    }

    public void setNumberOfSeats(int numberOfSeats) throws CarException {
        if (!checkNumberOfSeats(numberOfSeats))
            throw new CarException("Number of Seats must be positive");
        this.numberOfSeats = numberOfSeats;
    }

    public double calculateRentalPrice() {
        return 2.5 * getNumberOfSeats();
    }

    @Override
    public String toString() {
        return "License Plate: " + getLicensePlate() + " Number of seats: " + getNumberOfSeats() + " Rental price: " + calculateRentalPrice();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}