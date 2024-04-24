package SoSe23.C_BP.bp02_sub;

import java.util.List;
import java.util.ArrayList;

public class Main {

    // --------------------------------------
    public static void main(String[] args) {

        // Create array
        ArrayList<Animal> animals = new ArrayList<Animal>();

        // Fill array
        animals.add(new Dog("Fido", 3));
        animals.add(new Cat("Fluffy", 2));
        animals.add(new Cat("Kitty", 99));
        animals.add(new Dog("Lassie", 666));

        // Call functions
        makeAllNoises(animals);
        GetAllInformation(animals);
    }

    // --------------------------------------
    
    // makeALlNoises
    public static void makeAllNoises(List<Animal> animals) {
        for (Animal animal : animals) {
            animal.makeNoise();
        }
    }

    // --------------------------------------

    //GetAllInformation
    public static void GetAllInformation(List<Animal> animals) {
        for (Animal animal : animals) {
            animal.getInfo();
        }
    }

    // --------------------------------------
}