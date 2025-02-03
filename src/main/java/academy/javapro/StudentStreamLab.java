package academy.javapro;

import java.util.*;
import java.util.stream.*;

public class StudentStreamLab {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")
        );

        // TODO - Filtering: Students with GPA > 3.0
        List<Student> highGPA = students.stream()
                .filter(student -> student.getGpa() > 3.0)
                .collect(Collectors.toList());

        System.out.println("Students with GPA > 3.0 " + highGPA);

                // TODO - Mapping: Extract names of students with GPA > 3.0
        List<String> highGPAnames = students.stream()
                .filter(student -> student.getGpa() > 3.0)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("High GPA Student Names " + highGPAnames);

        // TODO - Reducing: Calculate the average GPA of all students
        List<Double> studentGPAs = students.stream()
                .map(Student::getGpa)
                .collect(Collectors.toList());
        double sum = 0.0;
        for (Double studentGPA : studentGPAs)
        {
            sum += studentGPA;
        }

        double avgGPA = sum / studentGPAs.size();

        System.out.println("Average GPA: " + avgGPA);

        // TODO Collecting: Collect all "Junior" students into a list
        List<Student> juniors = students.stream()
                .filter(student -> "Junior".equals(student.getCollegeYear()))
                .collect(Collectors.toList());

        System.out.println("Juniors: " + juniors);
    }
}
