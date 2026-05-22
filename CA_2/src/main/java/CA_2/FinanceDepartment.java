package CA_2;

// FinanceDepartment extends Department - represents the Finance department
public class FinanceDepartment extends Department {

    // Finance Department has an extra attribute - the annual budget they manage
    private double annualBudget;

    // Constructor - passes department details, plus the annual budget
    public FinanceDepartment(double annualBudget) {
        super("Finance", "FIN");
        this.annualBudget = annualBudget;
    }

    // Getter for annual budget
    public double getAnnualBudget() {
        return annualBudget;
    }

    // Setter for annual budget
    public void setAnnualBudget(double annualBudget) {
        this.annualBudget = annualBudget;
    }

    // Overrides Department toString to also show the annual budget
    @Override
    public String toString() {
        return super.toString() + " | Annual Budget: €" + String.format("%.2f", annualBudget);
    }
}