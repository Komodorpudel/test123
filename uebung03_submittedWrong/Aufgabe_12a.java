public class Aufgabe_12a {

    // --------------------------------------
    
    public static void main(String[] args) {
        // Ein CharSequence-Array anlegen, das groß genug ist, um alle Kommandozeilenparameter aufzunehmen
        CharSequence[] charSequences = new CharSequence[args.length];

        // Mit der Klassenmethode arraycopy der System-Klasse die Kommandozeilenparameter in das angelegte CharSequence-Array kopieren
        System.arraycopy(args, 0, charSequences, 0, args.length); // Copies starting at position 0 till position 0 + length -1 
 
        // Ein String-Objekt mit dem Wert "matik" anlegen, auf das eine CharSequence-Variable str zeigt
        CharSequence str = "matik";

        // Für jeden Eintrag des CharSequence-Arrays überprüfen, ob diese eine Teilzeichenkette enthalten, die str entspricht
        int index = -1;

        for (CharSequence a : charSequences) {
            index = index + 1;
            if (a.toString().contentEquals(str) == true) {
                System.out.printf("Die Teilzeichenkette '%s' wurde an der Position %d gefunden.\n", str, index);
            }
        }
    }

    // --------------------------------------
}
