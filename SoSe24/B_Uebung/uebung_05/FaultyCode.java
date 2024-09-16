import java.util.ArrayList;
import java.util.Scanner;

public class FaultyCode {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Test");
        System.out.println(list.get(-1));
        System.out.println(Integer.parseInt(list.get(0)));
        String s1 = "abc";
        Scanner myScanner = new Scanner(s1);
        int x = myScanner.nextInt();
        String s2 = null;
        String s3 = null;
        s2 = myScanner.next();
        s3 = myScanner.next();
        System.out.println(s2.toLowerCase() + " " + s3.toUpperCase());
    }
}
