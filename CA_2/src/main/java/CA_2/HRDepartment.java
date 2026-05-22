package CA_2;

// HRDepartment extends Department - represents the Human Resources department
public class HRDepartment extends Department {

    // HR Department has an extra attribute - the total number of employees it manages
    private int totalEmployees;

    // Constructor - passes department details, plus total employees managed
    public HRDepartment(int totalEmployees) {
        super("HR", "HR");
        this.totalEmployees = totalEmployees;
    }

    // Getter for total employees
    public int getTotalEmployees() {
        return totalEmployees;
    }

    // Setter for total employees
    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    // Overrides Department toString to also show total employees
    @Override
    public String toString() {
        return super.toString() + " | Total Employees Managed: " + totalEmployees;
    }
}