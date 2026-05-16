package CA_2;

// This is the main Employee class, other employee types will extend this
public class Employee {
    
    // Basic info for each employee
    private String name;         // employee name
    private String managerType;  // type of manager, e.g Head Manager
    private String department;   // department they work in, e.g HR
    
    // Constructor to create a new employee with their details
    public Employee(String name, String managerType, String department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }
    
    // Getters - used to get the employee details from other classes
    
    public String getName() {
        return name;
    }
    
    public String getManagerType() {
        return managerType;
    }
    
    public String getDepartment() {
        return department;
    }
    
    // Setters - used to update the employee details
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    // Prints employee info in a readable format when called
    @Override
    public String toString() {
        return "Name: " + name + " | Manager Type: " + managerType + " | Department: " + department;
    }
}

