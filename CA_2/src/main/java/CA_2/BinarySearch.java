package CA_2;

import java.util.ArrayList;

// This class searches for a name in a sorted list using Binary Search
public class BinarySearch {

    // Recursive binary search method
    // Returns the index of the name if found, or -1 if not found
    public static int search(ArrayList<String> list, String target, int low, int high) {

        // Base case - if low is greater than high, the name was not found
        if (low > high) {
            return -1;
        }

        // Find the middle index
        int mid = low + (high - low) / 2;

        // Check if the name is at the middle
        if (list.get(mid).equalsIgnoreCase(target)) {
            return mid;
        }

        // If target is smaller than middle, search the left half
        if (target.compareToIgnoreCase(list.get(mid)) < 0) {
            return search(list, target, low, mid - 1);
        }

        // If target is greater than middle, search the right half
        return search(list, target, mid + 1, high);
    }
}