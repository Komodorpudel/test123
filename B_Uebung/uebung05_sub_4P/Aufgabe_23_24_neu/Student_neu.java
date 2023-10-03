package B_Uebung.uebung05_sub_4P.Aufgabe_23_24_neu;

public class Student_neu {

    String name;
    int matrikelnummer;

    public Student_neu(String name, int matrikelnummer){
        setName(name);
        setMatrikelnummer(matrikelnummer);

    }

    public void setName(String name){
        if (checkName(name) == true){
            this.name = name;
        }

        else{
            throw new IllegalArgumentException("Ungültiger Name");
        }
    }

    public void setMatrikelnummer(int matrikelnummer) {

        if (checkMatrikelnummer(matrikelnummer) == true) {
            this.matrikelnummer = matrikelnummer;
        }
        else {
            throw new IllegalArgumentException("Ungültige Matrikelnummer");
        }
    }

    public String getName() {
        return name;
    }

    public int getMatrikelnummer() {
        return matrikelnummer;
    }

    public boolean checkName(String name) {
        if (name != null && name.length() > 0 && Character.isUpperCase(name.charAt(0))) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkMatrikelnummer (int matrikelnummer) {
        if (matrikelnummer >= 1000000 && matrikelnummer <= 9999999){
            return true;
        }
        return false;

    }

    @Override
    public String toString(){
        return "(" + matrikelnummer + "," + name +")";
    }
    
    
}
