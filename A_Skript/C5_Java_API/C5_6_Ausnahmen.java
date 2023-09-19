package A_Skript.C5_Java_API;

public class C5_6_Ausnahmen {

    public static void main (String[] args){

    }

    public Integer randomNumber(Integer) throws {

    }

    // Abfangen:

    public String createString(int){
        try {
            int max = 10;
            Integer myInt = randomNumber(max);
        }
        catch (IllegalArgumentException e){

        }
    }
    
}
