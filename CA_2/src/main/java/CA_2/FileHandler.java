package CA_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// This class handles reading the Applicants_Form.txt file
public class FileHandler {

    // Reads the file and returns a list of names
    public static ArrayList<String> readFile(String filename) {

        // ArrayList to store the names from the file
        ArrayList<String> names = new ArrayList<>();

        try {
            // Opens the file for reading
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            // Reads each line until the end of the file
            while ((line = reader.readLine()) != null) {
                // Only adds the line if it is not empty
                if (!line.trim().isEmpty()) {
                    names.add(line.trim());
                }
            }
            reader.close();

        } catch (IOException e) {
            // If the file is not found, print an error message
            System.out.println("Error reading file: " + e.getMessage());
        }

        return names;
    }
}