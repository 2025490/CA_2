package CA_2;

// TeamLead extends Manager - leads a specific team within a department
public class TeamLead extends Manager {

    // Team Lead has an extra attribute - the size of their team
    private int teamSize;

    // Constructor - passes all details to Manager, plus the team size
    public TeamLead(String name, String department, int teamSize) {
        super(name, "Team Lead", department, "Junior");
        this.teamSize = teamSize;
    }

    // Getter for team size
    public int getTeamSize() {
        return teamSize;
    }

    // Setter for team size
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    // Overrides Manager toString to also show team size
    @Override
    public String toString() {
        return super.toString() + " | Team Size: " + teamSize;
    }
}