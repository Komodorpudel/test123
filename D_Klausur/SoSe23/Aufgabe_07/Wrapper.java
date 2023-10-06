package D_Klausur.SoSe23.Aufgabe_07;

public class Wrapper {

    private static Wrapper unique = null;
    private Integer value;

    private Wrapper(){
        this.value = 0;
    }

    public static Wrapper instance(){
        if (unique == null) {
            unique = new Wrapper();
        }
        return unique;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
    
}

// die Idee:

// ich rufe Wrapper.instance() auf bevor es eventuell überhaupt erst ein Objekt gibt -> Daher static
// wenn es kein unique gibt, erstellter er einen Container und übergibt mir die refernence
// Danach kann ich keine neue Container erstellen, aber über instance() bekomme ich immer reference


    /*
    The unique instance variable should be static because it needs to be a class-level variable, not an instance-level variable.

    The instance() method should also be static because you need to call it on the class (i.e., Wrapper.instance()) rather than on an instance.

    To prevent creating instances from outside the class, the constructor should be private (which you've done correctly). */
