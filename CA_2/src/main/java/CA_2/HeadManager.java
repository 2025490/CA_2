package CA_2;

// HeadManager extends Manager - represents the highest level of management
public class HeadManager extends Manager {

    // Head Manager has an extra attribute - the number of departments they oversee
    private int departmentsOverseen;

    // Constructor - passes all details to Manager, plus departments overseen
    public HeadManager(String name, String department, int departmentsOverseen) {
        super(name, "Head Manager", department, "Senior");
        this.departmentsOverseen = departmentsOverseen;
    }

    // Getter for departments overseen
    public int getDepartmentsOverseen() {
        return departmentsOverseen;
    }

    // Setter for departments overseen
    public void setDepartmentsOverseen(int departmentsOverseen) {
        this.departmentsOverseen = departmentsOverseen;
    }

    // Overrides Manager toString to also show departments overseen
    @Override
    public String toString() {
        return super.toString() + " | Departments Overseen: " + departmentsOverseen;
    }
}