import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.dat";
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            employeeList = (ArrayList<Employee>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    public static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employeeList);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        loadFromFile();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = Double.parseDouble(scanner.nextLine());

                        employeeList.add(new Employee(id, name, dept, salary));
                        saveToFile();
                        System.out.println("Employee added successfully!");
                        break;

                    case 2:
                        if (employeeList.isEmpty()) {
                            System.out.println("No employee records found.");
                        } else {
                            System.out.println("\n--- Employee List ---");
                            for (Employee emp : employeeList) {
                                System.out.println(emp);
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Exiting... Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please choose between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter valid numeric values where required.");
            }
        } while (choice != 3);

        scanner.close();
    }
}