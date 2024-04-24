package SoSe24.C_BP.bp01_WIP;

public class Main {

    // -------------------------------------------------------
    public static String prepareWord(String input) { //Klassenmethode
        if (input == null) {
            return "";
        }

        String lowercase = input.toLowerCase();
        String cleaned = lowercase.replaceAll("[^a-z]", "");

        return cleaned;
    }

    // -------------------------------------------------------
    public static int[] letterQuantity(String word) {
        int[] letterCounts = new int[26]; // Array der Länge 26

        if (word == null) {
            return letterCounts; // Alle Werte in 'letterCounts' bleiben null (also 0)
        }

        // Loop
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            letterCounts[c - 'a']++; // Inkrementiert den entsprechenden Index im Array
        }

        return letterCounts; // Gibt das Array mit den Buchstabenhäufigkeiten zurück
    }

    // -------------------------------------------------------
    public static boolean checkEquals(int[] first, int[] second) {
        if (first == null || second == null) {
            return false; // Gibt false zurück, wenn eines der Arrays null ist
        }

        if (first.length != second.length) {
            return false; // Gibt false zurück, wenn die Längen unterschiedlich sind
        }

        // Vergleicht die Elemente an denselben Positionen
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }

        return true;
    }

    // -------------------------------------------------------
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Bitte geben Sie mindestens zwei Kommandozeilenparameter an.");
            return;
        }

        String baseWord = args[0];
        String preparedBaseWord = prepareWord(baseWord); // Bereinigen
        int[] baseLetterCounts = letterQuantity(preparedBaseWord); // Buchstabenhäufigkeit

        for (int i = 1; i < args.length; i++) {
            String currentWord = args[i];
            String preparedCurrentWord = prepareWord(currentWord);
            int[] currentLetterCounts = letterQuantity(preparedCurrentWord);

            if (checkEquals(baseLetterCounts, currentLetterCounts)) {
                System.out.println("\"" + currentWord + "\" ist ein Anagramm von \"" + baseWord + "\".");
            } else {
                System.out.println("\"" + currentWord + "\" ist kein Anagramm von \"" + baseWord + "\".");
            }
        }
    }
}
