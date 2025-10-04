import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    String name;
    int id;
    String designation;
    double salary;

    Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "employees.dat";

        while (true) {
            System.out.println("\n--- Employee Management ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String desig = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    Employee emp = new Employee(name, id, desig, salary);

                    try (ObjectOutputStream out = new ObjectOutputStream(
                            new FileOutputStream(fileName, true))) {
                        out.writeObject(emp);
                        System.out.println("Employee added successfully.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
                        while (true) {
                            Employee e = (Employee) in.readObject();
                            System.out.println("\nName: " + e.name);
                            System.out.println("ID: " + e.id);
                            System.out.println("Designation: " + e.designation);
                            System.out.println("Salary: " + e.salary);
                        }
                    } catch (EOFException e) {
                        // End of file reached
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
