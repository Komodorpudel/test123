package A_Skript.C4_Java_Grundlagen;

public class C4_2_Vererbung {

    public static void main (String[] args){
        Object o = new Object();


        //getClass
        Class <?> oClass = o.getClass();

        System.out.println(oClass);

        System.out.println(oClass.getSimpleName() + "\n");

        // Substitutionsprinzip
        Object a = new String("Hello Simon");

        Object b = new Object();

        System.out.println(a);
        System.out.println(b);

        //Polymorphismus
        StringBuilder s = new StringBuilder("Mein Name ist Simon");

        System.out.println(s.toString());
        System.out.println(b);

        // equals
        System.out.println(a.equals(b));
        Object c = b;
        b = a;
        System.out.println(a.equals(b));

        // instanceof
        System.out.println("String?");
        System.out.println("String?:" + c instanceof String);
        //Returns true because c is referencing an String;
        System.out.println("Object?:" + c instanceof Object);

        /// S47 - Instance of vs. getClass
        System.out.println("InstanceOf vs. getClass");

        Object ab = new String("Hello");
        Object cd = new Object();

        System.out.println(ab + "ab Object?" + ab instanceof Object);
        System.out.println(cd instanceof String);








    }
    
}
