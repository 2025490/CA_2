package CA_2;

import java.util.ArrayList;
import java.util.Scanner;

// Main class - this is where the program starts
public class CA_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("Welcome to the Bank Employee Management System");
        System.out.print("Please enter the filename to read: ");
        String filename = scanner.nextLine();

        // Read the file using FileHandler class
        employees = FileHandler.readFile(filename);

        // Check if file was read successfully
        if (employees.isEmpty()) {
            System.out.println("Error: File not found or empty. Please try again.");
            return;
        }

        System.out.println("File read successfully");

        // Sort the employees by name using Merge Sort
        ArrayList<String> names = new ArrayList<>();
        for (Employee e : employees) {
            names.add(e.getName());
        }
        names = MergeSort.sort(names);

        String choiceInput;
        int choice = 0;

        // Loop keeps the menu running until the user selects EXIT
        do {
            System.out.println("\nDo You wish to SORT or SEARCH:");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option);
            }

            System.out.print("Enter your choice: ");
            choiceInput = scanner.nextLine().trim();

            // Validate that the input is a number
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nSORT selected");
                    System.out.println("First 20 names in alphabetical order:");
                    System.out.println("--------------------------------------");
                    for (int i = 0; i < 20 && i < names.size(); i++) {
                        System.out.println((i + 1) + ". " + names.get(i));
                    }
                    break;

                case 2:
                    System.out.println("\nSEARCH selected");
                    System.out.print("Please enter the name to search: ");
                    String searchName = scanner.nextLine().trim();

                    int index = BinarySearch.search(names, searchName, 0, names.size() - 1);

                    if (index != -1) {
                        for (Employee e : employees) {
                            if (e.getName().equalsIgnoreCase(searchName)) {
                                System.out.println("\nEmployee found!");
                                System.out.println(e.toString());
                                break;
                            }
                        }
                    } else {
                        System.out.println("Employee not found. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("\nADD RECORDS selected");

                    // Get and validate employee name
                    String newName = "";
                    while (newName.isEmpty()) {
                        System.out.print("Please input the Employee Name: ");
                        newName = scanner.nextLine().trim();
                        if (newName.isEmpty()) {
                            System.out.println("Name cannot be empty. Please try again.");
                        }
                    }

                    // Get and validate manager type
                    System.out.println("Please select from the following Management Staff:");
                    System.out.println("1. Head Manager");
                    System.out.println("2. Assistant Manager");
                    System.out.println("3. Team Lead");

                    int managerChoice = 0;
                    while (managerChoice < 1 || managerChoice > 3) {
                        System.out.print("Enter your choice: ");
                        try {
                            managerChoice = Integer.parseInt(scanner.nextLine().trim());
                            if (managerChoice < 1 || managerChoice > 3) {
                                System.out.println("Invalid choice. Please enter 1, 2 or 3.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }

                    String managerType = "";
                    if (managerChoice == 1) managerType = "Head Manager";
                    else if (managerChoice == 2) managerType = "Assistant Manager";
                    else managerType = "Team Lead";

                    // Get and validate department
                    System.out.println("Please select the Department:");
                    System.out.println("1. IT Development");
                    System.out.println("2. HR");
                    System.out.println("3. Finance");
                    System.out.println("4. Marketing");
                    System.out.println("5. Customer Service");
                    System.out.println("6. Operations");
                    System.out.println("7. Accounting");
                    System.out.println("8. Sales");

                    int departmentChoice = 0;
                    while (departmentChoice < 1 || departmentChoice > 8) {
                        System.out.print("Enter your choice: ");
                        try {
                            departmentChoice = Integer.parseInt(scanner.nextLine().trim());
                            if (departmentChoice < 1 || departmentChoice > 8) {
                                System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }

                    String department = "";
                    if (departmentChoice == 1) department = "IT Development";
                    else if (departmentChoice == 2) department = "HR";
                    else if (departmentChoice == 3) department = "Finance";
                    else if (departmentChoice == 4) department = "Marketing";
                    else if (departmentChoice == 5) department = "Customer Service";
                    else if (departmentChoice == 6) department = "Operations";
                    else if (departmentChoice == 7) department = "Accounting";
                    else department = "Sales";

                    // Create new employee and add to lists
                    Employee newEmployee = new Employee(newName, managerType, department);
                    employees.add(newEmployee);
                    names.add(newName);
                    names = MergeSort.sort(names);

                    System.out.println("\n\"" + newName + "\" has been added as \"" + managerType + "\" to \"" + department + "\" successfully!");
                    System.out.println("\nNewly added record:");
                    System.out.println(newEmployee.toString());
                    break;

                case 4:
                    System.out.println("\nCreate Binary Tree selected");

                    BinaryTree tree = new BinaryTree();

                    for (Employee e : employees) {
                        tree.insert(e.getName(), e.getManagerType(), e.getDepartment());
                    }

                    tree.levelOrderTraversal();

                    System.out.println("\nTree Height: " + tree.getHeight(tree.root));
                    System.out.println("Total Nodes: " + tree.countNodes(tree.root));
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