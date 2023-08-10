package bp02_sub;

 // Cat
 public class Cat extends Animal {

    // Constructor
    public Cat(String name, int age){
        super(name, age);
    }

    // Override Make Noise
    public void makeNoise() {
        System.out.println("Meow");
    }
 }
