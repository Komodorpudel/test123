package SoSe23.C_BP.bp04_sub;

// Necessary classes
import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class Main {

    // --------------------------------------

    public static void main(String[] args) {

        // Erstellen eine leere Liste von Studenten die alle Instanzen der Klasse Student sind
        ArrayList<Student<Double>> studentList = new ArrayList<>();
        
        // Hinzufügen von Studenten zur Liste
        studentList.add(new Student<Double>("Hans", List.of(2.0, 2.0, 2.0)));
        studentList.add(new Student<Double>("Dieter", List.of(1.0, 1.0, 1.0)));
        studentList.add(new Student<Double>("Carina", List.of(3.0, 3.0, 3.0)));
        // Student ohne Noten
        studentList.add(new Student<Double>("Keine Note", List.of())); 


        // Call methods below
        double averageGrade = getAverageGrade(studentList);
        double bestGrade = findBestGrade(studentList);

        // Print
        System.out.println("Average Grade: " + averageGrade);
        System.out.println("Best Grade: " + bestGrade);

    }

    // --------------------------------------

    public static double getAverageGrade(List<Student<Double>> students) {
        // Create stream and return
        return students.stream()
                // Filter out 0
                .filter(student -> student.getAverageGrade() != 0)
                // Map averagegrades to single stream
                .mapToDouble(Student::getAverageGrade)
                // Calc average
                .average()
                .orElse(0.0);
    }

    // --------------------------------------

    public static Double findBestGrade(List<Student<Double>> students) {
        // Create stream and return
        return students.stream()
                // map student average grades to single stream
                .map(Student::getBestGrade)
                // Only non null
                .filter(grade -> grade != null)
                // Find min
                .min(Comparator.naturalOrder())
                .orElse(null);
    }
}
