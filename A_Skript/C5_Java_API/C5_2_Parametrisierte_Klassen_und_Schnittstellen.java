package SoSe23.A_Skript.C5_Java_API;

import java.util.ArrayList;
import java.util.Iterator;

public class C5_2_Parametrisierte_Klassen_und_Schnittstellen {

    public static void main (String [] args){
        ArrayList <String> meineArrayList = new ArrayList<String>();
        // Ändere das zu Object, und es geht

        meineArrayList.add("Ich bin ein String");

        // Compilerfehler
        //meineArrayList.add(new StringBuilder("ich bin ein sb"));

        meineArrayList.forEach(System.out::println);
        meineArrayList.forEach(n -> System.out.println(n));
        /*
        Both versions achieve the same output, but they represent different programming styles and can be preferred based on clarity, conciseness, or personal/team preference.

        Method Reference (System.out::println):
        Conciseness: This is more concise and is a direct reference to a method. It clearly shows that for every item in meineArrayList, the println method of System.out is being called.
        Readability: It's readable for those who are familiar with method references, but can be a bit cryptic for newcomers to Java 8 and functional programming.
        When to use: Use it when the lambda body would simply call a single method on the lambda parameter without any modification.

        Lambda Expression (n -> System.out.println(n)):
        Flexibility: It’s more flexible. If you wanted to add more operations for each item (like logging, additional calculations, etc.), you can easily expand the lambda body.
        Readability: It’s a bit more verbose, but also a bit more explicit, which can be helpful for those less familiar with the syntax of method references.
        When to use: Use it when the operation is more complex, when you have to do more than just calling one method on the lambda parameter, or when the method reference syntax becomes too cumbersome or less readable.
        In many cases, it comes down to the individual or team's coding style preference. Some developers find the method reference style more elegant and concise, while others prefer the explicitness of the full lambda. It’s good to be familiar with both, so you can use each where it makes the most sense.
        */
        meineArrayList.forEach(n -> System.out.println(n.getClass()));

        // Iterator (hasNext und next)
        ArrayList <String> meineArrayList2 = new ArrayList<String>();
        meineArrayList2.add("1");
        meineArrayList2.add("2");
        meineArrayList2.add("3");
        meineArrayList2.add("4");

        Iterator<String> it = meineArrayList2.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        /*
        Using an Iterator and using a loop (like a for-loop or enhanced for-loop) are both ways to iterate over elements of a collection, but they have different use cases and characteristics:
        Explicit Control over Iteration: With an Iterator, you have a more explicit control over the iteration process. You decide when to move to the next element, when to check if there's another element, and when to remove an element.
        Safe Removal: One of the main advantages of using an Iterator is the ability to safely remove elements from a collection while iterating. Directly removing elements from a collection during iteration can result in ConcurrentModificationException, but the Iterator's remove() method provides a safe way to do this.
        Generalization: All collections in the Java Collections Framework provide iterators, which means that you can use a consistent mechanism to iterate over any type of collection (lists, sets, queues, etc.).
        Explicitness: For some, using an iterator is more explicit and therefore more readable. You can see the checks for hasNext() and the calls to next(), which makes the iteration process clear.
        Historical Reasons: Before Java 5 introduced the enhanced for-loop (also known as the "for-each" loop), using Iterator was the preferred way to iterate over collections. Some older codebases might still use iterators for this reason.
        Less Elegant: For simple use-cases, using an Iterator can be more verbose than using an enhanced for-loop. The latter is often more concise and easier to read.

        */

        // Wildcard <?>

        // Anwendung bei Arrays so kompletter schwachsinn
        // ArrayList <? super Integer> myList = new ArrayList<? super Integer> ();


    }
    
}
