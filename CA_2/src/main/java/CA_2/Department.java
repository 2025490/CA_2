package CA_2;

public class Department {

    // Department has a name and a department code
    private String departmentName;
    private String departmentCode;

    // Constructor to create a new department
    public Department(String departmentName, String departmentCode) {
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }

    // Getter for department name
    public String getDepartmentName() {
        return departmentName;
    }

    // Getter for department code
    public String getDepartmentCode() {
        return departmentCode;
    }

    // Setter for department name
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // Setter for department code
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    // Prints department info in a readable format
    @Override
    public String toString() {
        return "Department: " + departmentName + " | Code: " + departmentCode;
    }
}
