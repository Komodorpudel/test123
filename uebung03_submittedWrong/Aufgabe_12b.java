public class Aufgabe_12b {

    // --------------------------------------

    public static CharSequence dateinamenserweiterung(CharSequence dateiname) {
        int index = -1;

        // Find out where dot is
        for (int i = 0; i < dateiname.length(); i = i + 1) {
            if (dateiname.charAt(i) == '.') {
                index = i;
            }
        }

        // Return "."" and everything after it
        if (index != -1) {
            return dateiname.subSequence(index, dateiname.length());
        }

        else {
            return "";
        }
    }

    // --------------------------------------

    public static void main(String[] args) {

        // Drei Objekte erstellen
        String dateinameString = "beispiel.txt";
        StringBuffer dateinameStringBuffer = new StringBuffer("beispiel.pdf");
        StringBuilder dateinameStringBuilder = new StringBuilder("beispiel.jpg");
        StringBuilder dateinameTest = new StringBuilder("beispiel");

        // Ausgabe
        System.out.println("Dateinamenserweiterung für String: " + dateinamenserweiterung(dateinameString));
        System.out.println("Dateinamenserweiterung für StringBuffer: " + dateinamenserweiterung(dateinameStringBuffer));
        System.out.println("Dateinamenserweiterung für StringBuilder: " + dateinamenserweiterung(dateinameStringBuilder));
        System.out.println("Dateinamenserweiterung für StringBuilderTest: " + dateinamenserweiterung(dateinameTest));
    }

    // --------------------------------------
}
