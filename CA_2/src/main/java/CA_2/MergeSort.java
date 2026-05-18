package CA_2;

import java.util.ArrayList;

// This class sorts a list of names alphabetically using Merge Sort
public class MergeSort {

    // Main method that splits the list and sorts it recursively
    public static ArrayList<String> sort(ArrayList<String> list) {

        // Base case - if the list has 1 or 0 elements, it is already sorted
        if (list.size() <= 1) {
            return list;
        }

        // Find the middle of the list
        int mid = list.size() / 2;

        // Split the list into two halves
        ArrayList<String> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<String> right = new ArrayList<>(list.subList(mid, list.size()));

        // Recursively sort both halves
        left = sort(left);
        right = sort(right);

        // Merge the two sorted halves together
        return merge(left, right);
    }

    // This method merges two sorted lists into one sorted list
    private static ArrayList<String> merge(ArrayList<String> left, ArrayList<String> right) {

        // Result list to store the merged names
        ArrayList<String> result = new ArrayList<>();

        int i = 0; // index for left list
        int j = 0; // index for right list

        // Compare elements from both lists and add the smaller one to result
        while (i < left.size() && j < right.size()) {
            // compareToIgnoreCase compares names alphabetically, ignoring upper/lower case
            if (left.get(i).compareToIgnoreCase(right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Add any remaining elements from the left list
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        // Add any remaining elements from the right list
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}