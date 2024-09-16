package SoSe23.B_Uebung.uebung04_sub_4P.Aufgabe_19;

// Necessary packages/classes:
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.function.Predicate;
//

public class Aufgabe_19a {

    // --------------------------------------

    public static void main(String[] args) {

        // 1. eine Liste f¨ur String-Objekte erzeugt und diese mit den Kommandozeilenparametern
        //    bef¨ullt (verwenden Sie daf¨ur eine geeignete Methode der Klasse Arrays),
        List<String> list = Arrays.asList(args); // btw: list vs. array: Array is fixed size upon creation

        // 2. ein UnaryOperator-Objekt f¨ur Strings erstellt, dass alle Kleinbuchstaben einer ¨ubergebenen
        //    Zeichenkette zu Großbuchstaben konvertiert,
        UnaryOperator<String> toUpperCase = String::toUpperCase;

        // UnaryOperator<String> toUpperCase = x -> x.toUpperCase();


        /* In Java, UnaryOperator<String> toUpperCase = String::toUpperCase; is a method reference that creates a UnaryOperator<String> which transforms a given string to uppercase.

        UnaryOperator<String> specifies that it's an operation with a single operand of type String, that returns a result of type String.

        The :: operator is the method reference operator in Java. It's used to call a method on the input argument. In this case, it calls the toUpperCase method on the instance of String.

        So, toUpperCase is a UnaryOperator<String> which, when applied to a string, returns the uppercase version of that string.
        */

        // 3. damit alle Zeichenkette in der vorher erstellten Liste transformiert,
        list.replaceAll(toUpperCase);

        // 4. mit einem Lambda-Ausdruck f¨ur ein Pr¨adikat alle Zeichenketten, die mit "A" beginnen,
        //    entfernt und
        Predicate<String> startsWithA = s -> s.startsWith("A");
        list.removeIf(startsWithA);

        // 5. am Ende alle Zeichenketten jeweils in einer eigenen Zeile mithilfe einer Methodenreferenz
        //    ausgibt.
        list.forEach(System.out::println);
    }

    // --------------------------------------

}