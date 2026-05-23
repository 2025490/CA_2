package CA_2;

// AssistantManager extends Manager - supports the Head Manager in daily operations
public class AssistantManager extends Manager {

    // Assistant Manager has an extra attribute - the Head Manager they report to
    private String reportsTo;

    // Constructor - passes all details to Manager, plus who they report to
    public AssistantManager(String name, String department, String reportsTo) {
        super(name, "Assistant Manager", department, "Mid");
        this.reportsTo = reportsTo;
    }

    // Getter for reportsTo
    public String getReportsTo() {
        return reportsTo;
    }

    // Setter for reportsTo
    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

    // Overrides Manager toString to also show who they report to
    @Override
    public String toString() {
        return super.toString() + " | Reports To: " + reportsTo;
    }
}