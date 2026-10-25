import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentMarksRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> marksList = new ArrayList<>();

        System.out.print("Koyti student-er marks enter korte chao? ");
        int n = scanner.nextInt();

        System.out.println("Student-der marks guli input dao:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " marks: ");
            int marks = scanner.nextInt();
            marksList.add(marks);
        }

        if (marksList.isEmpty()) {
            System.out.println("Kono marks enter kora hoyni!");
        } else {
            int highest = Collections.max(marksList);
            int lowest = Collections.min(marksList);

            System.out.println("\n--- Student Marks Summary ---");
            System.out.println("All Marks: " + marksList);
            System.out.println("Highest Marks: " + highest);
            System.out.println("Lowest Marks: " + lowest);
        }
        scanner.close();
    }
}
