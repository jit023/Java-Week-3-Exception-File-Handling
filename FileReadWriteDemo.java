import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWriteDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "user_output.txt";

        System.out.print("Enter text to write into the file: ");
        String userInputText = scanner.nextLine();

        // Writing to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(userInputText);
            System.out.println("Data successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // Reading from file
        System.out.println("\nReading from file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        scanner.close();
    }
}
