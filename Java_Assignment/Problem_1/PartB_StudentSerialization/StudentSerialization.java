import java.io.*;

class Student implements Serializable {
    int studentID;
    String name;
    String grade;

    Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }
}

public class StudentSerialization {
    public static void main(String[] args) {
        Student s = new Student(101, "Alice", "A");

        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.dat"))) {
            out.writeObject(s);
            System.out.println("Student object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.dat"))) {
            Student deserializedStudent = (Student) in.readObject();
            System.out.println("Deserialized Student:");
            System.out.println("ID: " + deserializedStudent.studentID);
            System.out.println("Name: " + deserializedStudent.name);
            System.out.println("Grade: " + deserializedStudent.grade);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
