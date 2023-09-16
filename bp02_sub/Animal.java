package bp02_sub;


// --------------------------------------

public abstract class Animal{

    // Attributes
    private String name;
    private int age;
    //

    // Constructor
    // -- Empty Constructor
    public Animal() {

    }

    // -- Constructor to set all attributes
    public Animal(String name, int age) {
        setName(name);
        setAge(age);
    }
    //

    // Methods
    // -- Setter name
    public void setName(String name) {
        this.name = name;
    }

    // -- Setter age
    public void setAge(int age) {
        this.age = age;
    }

    // -- Make Noise (abstract)
    public abstract void makeNoise();

    // -- Get Info
    public void getInfo(){
        System.out.println(" Name" + this.name + ", Age:" + this.age);
    }
    //
}

// Test

// Cocksucker