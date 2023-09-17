package A_Skript.C4_Java_Grundlagen;

public class C4_7_Zeichenketten {
    
    public static void main(String[] args){
        String s = new String("Ich bin der Simon");
        String h = new String("Ich bin nicht der Simon");

        //length
        System.out.println(s.length());

        //charAt
        System.out.println("CharAt:\n" + s.charAt(4));

        //toUpperCase:
        System.out.println("toUpperCase:\n" + s.toUpperCase());

        //compareTo:
        System.out.println("compareTo:\n" + s.compareTo(h));
    

        //Concat
        String i = s.concat(h);
        System.out.println("Concat:\n" + i);

        //S84 - StringBuilder
        System.out.println("\nStringBuilder:");

        // new StringBuilder
        StringBuilder sb = new StringBuilder("Ich bin ein StringBuilder");
        System.out.println(sb);

        // Anfangskapaziät
        StringBuilder sbLeer = new StringBuilder (5);

        //Insert
        System.out.println("\nOffset:");
        sb.insert(0, "ich bin ein Offset");
        System.out.println(sb);

    }
}
