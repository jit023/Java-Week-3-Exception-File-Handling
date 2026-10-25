import java.util.Scanner;

public class MultipleCatchDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Array elements: [10, 20, 30, 40, 50]");
        System.out.print("Enter an index to divide (0-4): ");
        
        try {
            int index = Integer.parseInt(scanner.nextLine());
            int value = numbers[index];
            
            System.out.print("Enter divisor: ");
            int divisor = Integer.parseInt(scanner.nextLine());
            
            int result = value / divisor;
            System.out.println("Result (numbers[" + index + "] / " + divisor + ") = " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: Arithmetic error (Division by zero).");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: Invalid array index accessed.");
        } catch (NumberFormatException e) {
            System.out.println("Exception Caught: Please enter valid integer numbers.");
        } finally {
            System.out.println("Program execution finished.");
            scanner.close();
        }
    }
}
