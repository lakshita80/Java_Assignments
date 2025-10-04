import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " | Marks: " + marks;
    }
}

public class StudentFiltering {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 80),
            new Student("Bob", 70),
            new Student("Charlie", 90),
            new Student("David", 65)
        );

        System.out.println("Students with marks > 75, sorted by marks:");
        students.stream()
            .filter(s -> s.marks > 75)                // filter students > 75
            .sorted(Comparator.comparingDouble(s -> s.marks))  // sort by marks ascending
            .map(s -> s.name)                          // extract names
            .forEach(System.out::println);
    }
}
