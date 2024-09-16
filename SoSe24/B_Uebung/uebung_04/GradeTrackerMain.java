import java.util.Scanner;

public class GradeTrackerMain {
    public static final String enrolmentNumberInput = "Please enter the enrolment number you want to add a grade to (Enter -1 to stop):";

    public static void main(String[] args) {
        GradeTracker tracker = new GradeTracker();
        Scanner myScanner = new Scanner(System.in);
        System.out.println(enrolmentNumberInput);
        int input = myScanner.nextInt();
        while (input != -1) {
            System.out.println("Please enter the grade you want to add to " + input + ":");
            double grade = myScanner.nextDouble();
            tracker.addGrade(input, grade);
            System.out.println(enrolmentNumberInput);
            input = myScanner.nextInt();
        }
        System.out.println("Average grade of all students: " + String.format("%.2f",tracker.calculateAverageAverageGrade()));
        myScanner.close();
    }
}
