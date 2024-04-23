package SoSe23.B_Uebung.uebung05_sub_4P.Aufgabe_23_24;


public class Student {

    // --------------------------------------

    // Atrribute:
    // a.1. Ein Student-Objekt hat einen Namen und eine Matrikelnummer
    private String name;
    private int matrikelNummer;

    // --------------------------------------

    // Konstruktur:
    public Student(String name, int matrikelNummer) {
        // Man könnte auch this.name = name etc. verwenden,
        // aber dann wäre die Prüfung des Namens und Zeichenkette über set unten nicht möglich
        setName(name);
        setMatrikelNummer(matrikelNummer);
    }

    // --------------------------------------

    // get Name
    public String getName() {
        return name;
    }

    // --------------------------------------

    // setName
    public void setName(String name) {

        // a.2. Der Name ist eine Zeichenkette und darf nicht null oder leer sein und muss mit einem
        //    Großbuchstaben beginnen.
        if (name == null || name.trim().isEmpty() || !Character.isUpperCase(name.charAt(0))) {

            // a.4a. Wird versucht, ein Student-Objekt mit ung¨ultigen Werten f¨ur Name (oder Matrikelnummer
            //    zu erstellen, so soll eine IllegalArgumentException geworfen werden.)
            throw new IllegalArgumentException("Ungültiger Name");
        }

        this.name = name;
    }

    // --------------------------------------

    // getMatrikelNummber
    public int getMatrikelNummer() {
        return matrikelNummer;
    }

    // --------------------------------------

    // setMatrikelNummber
    public void setMatrikelNummer(int matrikelNummer) {

        // a.3. Die Matrikelnummer ist eine nat¨urliche Zahl und muss siebenstellig sein.
        if (matrikelNummer < 1000000 || matrikelNummer > 9999999) {

            // a.4b. Wird versucht, ein Student-Objekt mit ung¨ultigen Werten (f¨ur Name oder) Matrikelnummer
            //    zu erstellen, so soll eine IllegalArgumentException geworfen werden.
            throw new IllegalArgumentException("Ungültige Matrikelnummer");
        }

        this.matrikelNummer = matrikelNummer;
    }

    // --------------------------------------


    // a.5. Die String-Ausgabe eines Student-Objekts soll die Form (Matrikelnummer, Name)
    //    haben.
    @Override // Annotation nicht notwendig, aber good practice -> Jeder versteht, dass man eine methode aus einer superclass überschreibt
    public String toString() {
        return "(" + matrikelNummer + ", " + name + ")";
    }

    // --------------------------------------
    
}
