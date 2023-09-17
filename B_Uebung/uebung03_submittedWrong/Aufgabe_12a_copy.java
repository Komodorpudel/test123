package B_Uebung.uebung03_submittedWrong;

public class Aufgabe_12a_copy {

    // --------------------------------------
    
    public static void main(String[] args) {
        // Ein CharSequence-Array anlegen, das groß genug ist, um alle Kommandozeilenparameter aufzunehmen
        CharSequence[] charSequences = new CharSequence[args.length];

        // Mit der Klassenmethode arraycopy der System-Klasse die Kommandozeilenparameter in das angelegte CharSequence-Array kopieren
        System.arraycopy(args, 0, charSequences, 0, args.length); // Copies starting at position 0 till position 0 + length -1 
 
        // Ein String-Objekt mit dem Wert "matik" anlegen, auf das eine CharSequence-Variable str zeigt
        CharSequence str = "matik";

        // Für jeden Eintrag des CharSequence-Arrays überprüfen, ob diese eine Teilzeichenkette enthalten, die str entspricht

        for (int i = 0; i < charSequences.length; i++) {
            int position = charSequences[i].toString().indexOf(str.toString());
            if (position != -1) {
                System.out.println("The substring was found in element " + i + " at index: " + position);
            }
        }
    }

    // --------------------------------------
}
