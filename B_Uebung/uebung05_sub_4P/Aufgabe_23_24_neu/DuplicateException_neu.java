package B_Uebung.uebung05_sub_4P.Aufgabe_23_24_neu;

public class DuplicateException_neu extends Exception {
    
    public DuplicateException_neu (String attribute, String duplicateValue){
        super(attribute + "schon vergeben" + duplicateValue);
    }
    
}
