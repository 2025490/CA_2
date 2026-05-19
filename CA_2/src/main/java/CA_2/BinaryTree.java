package CA_2;

import java.util.ArrayList;

// This class represents the employee hierarchy as a Binary Tree
// Uses level-order (breadth-first) insertion as taught by the professor
public class BinaryTree {

    // Each node stores employee details
    static class Node {
        String name;
        String managerType;
        String department;
        Node left, right;

        // Constructor for each node
        Node(String name, String managerType, String department) {
            this.name = name;
            this.managerType = managerType;
            this.department = department;
            left = right = null;
        }
    }

    // Root of the tree
    Node root;

    // Constructor - starts with empty tree
    public BinaryTree() {
        root = null;
    }

    // Inserts a new employee into the tree using level-order insertion
    // Fills left first, then right, level by level
    public void insert(String name, String managerType, String department) {

        Node newNode = new Node(name, managerType, department);

        // If tree is empty, new node becomes the root
        if (root == null) {
            root = newNode;
            return;
        }

        // Use an array as queue for level-order insertion
        // Following the professors BFSArrayQueue approach
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Get the first node in the queue
            Node current = queue.remove(0);

            // If left spot is empty, insert here
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            // If right spot is empty, insert here
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Displays the tree using level-order traversal
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }

        ArrayList<Node> queue = new ArrayList<>();
        queue.add(root);
        int level = 1;

        System.out.println("\nEmployee Hierarchy - Level Order Traversal:");
        System.out.println("--------------------------------------------");

        while (!queue.isEmpty()) {
            // Count nodes at current level
            int levelSize = queue.size();
            System.out.print("Level " + level + ": ");

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.remove(0);
                System.out.print("[" + current.name + " | " + current.managerType + " | " + current.department + "] ");

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            System.out.println();
            level++;
        }
    }

    // Calculates the height of the tree
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        // Recursively calculate height of left and right subtrees
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Return the larger height plus 1 for current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Counts total number of nodes in the tree
    public int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        // Recursively count left and right subtrees
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}