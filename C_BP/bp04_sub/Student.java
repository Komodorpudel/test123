package C_BP.bp04_sub;

// Necessary classes
import java.util.*;
// Needed for List and stream

// Class Student
public class Student<T extends Number & Comparable<T>>{ // Class uses T which must be subclass of Number and implement Comparable

    // Private Attribute
    private String name;
    private List <T> grades;

    // Konstruktor (immer gleicher name wie Class)
    public Student (String name, List<T> grades) {
        this.name = name;
        this.grades = grades;
    }

    // --------------------------------------

    // AverageGrade
    public double getAverageGrade() {

        // Verwenden eines Streams, um den Durchschnitt zu berechnen
        // Create stream and returns
        return grades.stream() 
                         // I need to tell Java how to make it a double
                        .mapToDouble(grade123 -> grade123.doubleValue())
                        // Calculate average of all values in stream
                        .average()
                        // Throw exception; have to return 0 since double
                        .orElse(0);

    }

    // --------------------------------------

    //getBestGrade
    public T getBestGrade() {

        if (grades.isEmpty()) {
            return null; // Return a default value, such as 0
        }
        
        // Using a Stream to find the best grade
        // Creates stream and returns
        return grades.stream()
                     // Find minimum - goes through list and compares each element with next
                     .min(Comparator.naturalOrder()) // alles andere kacke wegen T
                     // Throw exception
                     .orElse(null);
    }

    // --------------------------------------

    // Getters and setters for name and grades
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getGrades() {
        return this.grades;
    }

    public void setGrades(List<T> grades) {
        this.grades = grades;
    }

}