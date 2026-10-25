import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordCounterFromFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "sample_text.txt";

        System.out.print("Enter sentences to store in the file: ");
        String userInput = scanner.nextLine();

        // Write user input to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(userInput);
            System.out.println("Text saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // Count words from the file
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
            System.out.println("Total word count in the file: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}
