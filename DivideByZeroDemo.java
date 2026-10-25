import java.util.Scanner;

public class DivideByZeroDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter numerator (dividend): ");
        int numerator = scanner.nextInt();
        
        System.out.print("Enter denominator (divisor): ");
        int denominator = scanner.nextInt();
        
        try {
            int result = numerator / denominator;
            System.out.println("Result: " + numerator + " / " + denominator + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: Division by zero is not allowed!");
        } finally {
            System.out.println("Execution completed.");
            scanner.close();
        }
    }
}
