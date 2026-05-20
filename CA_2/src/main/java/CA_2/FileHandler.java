package CA_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// This class handles reading the Applicants_Form.txt file
public class FileHandler {

    // Reads the CSV file and returns a list of employees
    public static ArrayList<Employee> readFile(String filename) {

        ArrayList<Employee> employees = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            // Skip the first line (header)
            reader.readLine();

            // Read each line
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    // Split the line by comma
                    String[] parts = line.split(",");

                    // Get first name and last name
                    String name = parts[0].trim() + " " + parts[1].trim();

                    // Get department
                    String department = parts[5].trim();

                    // Get job title as manager type
                    String managerType = parts[7].trim();

                    // Create a new employee and add to list
                    employees.add(new Employee(name, managerType, department));
                }
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return employees;
    }
}