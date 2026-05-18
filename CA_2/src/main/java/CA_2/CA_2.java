package CA_2;

import java.util.ArrayList;
import java.util.Scanner;

// Main class - this is where the program starts
public class CA_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        ArrayList<String> names = new ArrayList<>();

        System.out.println("Welcome to the Bank Employee Management System");
        System.out.print("Please enter the filename to read: ");
        String filename = scanner.nextLine();

        // Read the file using FileHandler class
        names = FileHandler.readFile(filename);

        // Check if file was read successfully
        if (names.isEmpty()) {
            System.out.println("Error: File not found or empty. Please try again.");
            return;
        }

        System.out.println("File read successfully");

        // Sort the names using Merge Sort
        names = MergeSort.sort(names);

        // Loop keeps the menu running until the user selects EXIT
        do {
            // Print each menu option using the enum
            System.out.println("\nDo You wish to SORT or SEARCH:");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option);
            }

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // Handle the user choice
            switch (choice) {
                case 1:
                    System.out.println("\nSORT selected");
                    System.out.println("First 20 names in alphabetical order:");
                    System.out.println("--------------------------------------");
                    // Display only the first 20 names
                    for (int i = 0; i < 20 && i < names.size(); i++) {
                        System.out.println((i + 1) + ". " + names.get(i));
                    }
                    break;
                case 2:
                    System.out.println("SEARCH selected");
                    break;
                case 3:
                    System.out.println("ADD RECORDS selected");
                    break;
                case 4:
                    System.out.println("CREATE BINARY TREE selected");
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}