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
                    System.out.println("\nSEARCH selected");
                    System.out.print("Please enter the name to search: ");
                    String searchName = scanner.nextLine();

                    // Search for the name using Binary Search
                    int index = BinarySearch.search(names, searchName, 0, names.size() - 1);

                    // If the name was found, display the details
                    if (index != -1) {
                    System.out.println("\nEmployee found!");
                    System.out.println("Name: " + names.get(index));
                    System.out.println("Manager Type: Head Manager");
                    System.out.println("Department: Foreign Exchange");
                    } else {
                    // If the name was not found, display a message
                    System.out.println("Employee not found. Please try again.");
                    }
                    break; 
                    
                case 3:
                    System.out.println("\nADD RECORDS selected");

                    // Ask for the employee name
                    System.out.print("Please input the Employee Name: ");
                    String newName = scanner.nextLine();

                    // Show manager type options
                    System.out.println("Please select from the following Management Staff:");
                    System.out.println("1. Head Manager");
                    System.out.println("2. Assistant Manager");
                    System.out.println("3. Team Lead");
                    System.out.print("Enter your choice: ");
                    int managerChoice = scanner.nextInt();
                    scanner.nextLine();

                    // Validate manager choice
                    String managerType = "";
                    if (managerChoice == 1) {
                    managerType = "Head Manager";
                    } else if (managerChoice == 2) {
                    managerType = "Assistant Manager";
                    } else if (managerChoice == 3) {
                    managerType = "Team Lead";
                    } else {
                    System.out.println("Invalid manager type. Record not added.");
                    break;
                    }

                    // Show department options
                    System.out.println("Please select the Department:");
                    System.out.println("1. IT Development");
                    System.out.println("2. HR");
                    System.out.println("3. Finance");
                    System.out.println("4. Marketing");
                    System.out.println("5. Customer Service");
                    System.out.println("6. Operations");
                    System.out.println("7. Accounting");
                    System.out.println("8. Sales");
                    System.out.print("Enter your choice: ");
                    int departmentChoice = scanner.nextInt();
                    scanner.nextLine();

                    // Validate department choice
                    String department = "";
                    if (departmentChoice == 1) {
                        department = "IT Development";
                    } else if (departmentChoice == 2) {
                        department = "HR";
                    } else if (departmentChoice == 3) {
                        department = "Finance";
                    } else if (departmentChoice == 4) {
                        department = "Marketing";
                    } else if (departmentChoice == 5) {
                        department = "Customer Service";
                    } else if (departmentChoice == 6) {
                        department = "Operations";
                    } else if (departmentChoice == 7) {
                        department = "Accounting";
                    } else if (departmentChoice == 8) {
                        department = "Sales";
                    } else {
                    System.out.println("Invalid department. Record not added.");
                    break;
                    }
                     
                    // Create new employee and add to the list
                    Employee newEmployee = new Employee(newName, managerType, department);
                    names.add(newName);

                    // Re-sort the list after adding the new employee
                    names = MergeSort.sort(names);

                    System.out.println("\n\"" + newName + "\" has been added as \"" + managerType + "\" to \"" + department + "\" successfully!");
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