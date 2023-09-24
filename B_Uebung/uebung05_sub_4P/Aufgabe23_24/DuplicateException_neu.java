package B_Uebung.uebung05_sub_4P.Aufgabe23_24;

public class DuplicateException_neu extends Exception {
    public DuplicateException_neu(String attribute, String duplicateValue){
        super(attribute + "schon vergeben" + duplicateValue);
    }
    
}
