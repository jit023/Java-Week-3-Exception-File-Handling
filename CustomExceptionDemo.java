import java.util.Scanner;

// Custom Exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age must be between 0 and 120.");
        } else {
            System.out.println("Access granted! Valid age entered: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        try {
            int age = Integer.parseInt(scanner.nextLine());
            checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer for age.");
        } finally {
            scanner.close();
        }
    }
}
