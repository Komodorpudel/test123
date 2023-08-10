package uebung05_sub_4P.A22;

// Necessary packages/classes:
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//

public class Aufgabe_22c {

    // --------------------------------------

    public static void main(String[] args) {

        // Random seed
        Random random = new Random();

        // 1. ein Supplier-Objekt fur ¨ Character-Objekte mit zuf¨alligen, lateinischen Kleinbuchstaben erzeugt,
        Supplier<Character> characterSupplier = () -> (char) ('a' + random.nextInt(26));

        // 2. ein Stream-Objekt fur ¨ String-Objekte erzeugt, welches das zuvor erstellte SupplierObjekt verwendet,
        //    um W¨orter bestehend aus zuf¨alligen lateinischen Kleinbuchstaben ...
        // SAH: Lamda mit Anweisungsblock: "Für jedes Wort mache folgendes:"
        Stream<String> wordStream = Stream.generate(() -> {

            // SAH: Für jedes Wort ein anfänglich leerer String
            StringBuilder wordBuilder = new StringBuilder();

            // ... mit zuf¨alliger L¨ange zwischen 5 und 10 Zeichen (jeweils einschließlich) zu erzeugen,
            // SAH: Für jedes Wort random length und befüülen via loop
            int length = 5 + random.nextInt(6); 
            for (int i = 0; i < length; i = i + 1) {
                wordBuilder.append(characterSupplier.get());
            }
            // SAH: wordBuilder in String verwandeln und Return
            return wordBuilder.toString();
            
        })
        // 3. die L¨ange dieses Streams auf 500 beschr¨ankt,
        .limit(500);

        // 4. einen IntStream mit den L¨angen der Worte erzeugt und
        IntStream lengthStream = wordStream.mapToInt(String::length);

        // 5. den Durchschnittswert dieser L¨angen berechnet und ausgibt (verwenden Sie die
        //    orElseThrow()-Methode des erhaltenen OptionalDouble-Objects).
        double average = lengthStream.average().orElseThrow();
        System.out.println("Durchschnittliche Wortlänge: " + average);
    }

    // --------------------------------------

}
