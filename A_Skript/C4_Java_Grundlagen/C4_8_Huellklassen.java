package A_Skript.C4_Java_Grundlagen;

public class C4_8_Huellklassen {

    public static void main (String[] args){

        int i = 5;

        Integer h = Integer.valueOf(i);

        System.out.println(h);
        System.out.println(h.getClass());

        String s = "2323";

        Integer j = Integer.valueOf(s);
        System.out.println(j);
        System.out.println(j.getClass());

    }
    
}
