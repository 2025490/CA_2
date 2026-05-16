package CA_2;

// Manager extends Employee, meaning it inherits all the attributes and methods from Employee
public class Manager extends Employee {

    // Manager has an extra attribute - their level of authority in the bank
    private String managerLevel;

    // Constructor - we pass all employee details plus the manager level
    public Manager(String name, String managerType, String department, String managerLevel) {
        // This calls the Employee constructor to set name, managerType and department
        super(name, managerType, department);
        this.managerLevel = managerLevel;
    }

    // Getter for manager level
    public String getManagerLevel() {
        return managerLevel;
    }

    // Setter for manager level
    public void setManagerLevel(String managerLevel) {
        this.managerLevel = managerLevel;
    }

    // Overrides the Employee toString to also show the manager level
    @Override
    public String toString() {
        return super.toString() + " | Manager Level: " + managerLevel;
    }
}
