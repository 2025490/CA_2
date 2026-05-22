package CA_2;

// ITDepartment extends Department - represents the IT Development department
public class ITDepartment extends Department {

    // IT Department has an extra attribute - the main programming language used
    private String mainLanguage;

    // Constructor - passes department details, plus the main programming language
    public ITDepartment(String mainLanguage) {
        super("IT Development", "IT");
        this.mainLanguage = mainLanguage;
    }

    // Getter for main language
    public String getMainLanguage() {
        return mainLanguage;
    }

    // Setter for main language
    public void setMainLanguage(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    // Overrides Department toString to also show the main language
    @Override
    public String toString() {
        return super.toString() + " | Main Language: " + mainLanguage;
    }
}