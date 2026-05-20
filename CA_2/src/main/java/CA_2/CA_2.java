package CA_2;

import java.util.ArrayList;
import java.util.Scanner;

// Main class - this is where the program starts
public class CA_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
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

        // Loop keeps the menu running until the user selects EXIT
        do {
            System.out.println("\nDo You wish to SORT or SEARCH:");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option);
            }

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

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
                    String searchName = scanner.nextLine();

                    int index = BinarySearch.search(names, searchName, 0, names.size() - 1);

                    if (index != -1) {
                        // Find the full employee details
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

                    System.out.print("Please input the Employee Name: ");
                    String newName = scanner.nextLine();

                    System.out.println("Please select from the following Management Staff:");
                    System.out.println("1. Head Manager");
                    System.out.println("2. Assistant Manager");
                    System.out.println("3. Team Lead");
                    System.out.print("Enter your choice: ");
                    int managerChoice = scanner.nextInt();
                    scanner.nextLine();

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

                    // Create new employee and add to lists
                    Employee newEmployee = new Employee(newName, managerType, department);
                    employees.add(newEmployee);
                    names.add(newName);
                    names = MergeSort.sort(names);

                    System.out.println("\n\"" + newName + "\" has been added as \"" + managerType + "\" to \"" + department + "\" successfully!");

                    // Display all newly added records
                    System.out.println("\nNewly added records:");
                    System.out.println(newEmployee.toString());
                    break;

                case 4:
                    System.out.println("\nCreate Binary Tree selected");

                    BinaryTree tree = new BinaryTree();

                    // Insert all employees from the file into the tree
                    for (Employee e : employees) {
                        tree.insert(e.getName(), e.getManagerType(), e.getDepartment());
                    }

                    // Display the tree
                    tree.levelOrderTraversal();

                    // Display tree height and total nodes
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