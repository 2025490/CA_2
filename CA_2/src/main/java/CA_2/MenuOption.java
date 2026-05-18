package CA_2;

// Enum to define the menu options available to the user
// Using an Enum makes the menu more organised and structured
public enum MenuOption {

    SORT(1, "SORT"),
    SEARCH(2, "SEARCH"),
    ADD_RECORDS(3, "ADD RECORDS"),
    CREATE_BINARY_TREE(4, "CREATE BINARY TREE"),
    EXIT(5, "EXIT");

    // Each menu option has a number and a description
    private final int number;
    private final String description;

    // Constructor for each menu option
    MenuOption(int number, String description) {
        this.number = number;
        this.description = description;
    }

    // Getter for the number
    public int getNumber() {
        return number;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Prints the menu option in a readable format
    @Override
    public String toString() {
        return number + ". " + description;
    }
}