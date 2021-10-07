package hardcore.model;

public class Instance {
    private String textCalculator;
    private String numberOfInstancesField;
    private String firstName;
    private String lastName;


    public Instance(String textCalculator, String numberOfInstancesField, String firstName, String lastName) {
        this.textCalculator = textCalculator;
        this.numberOfInstancesField = numberOfInstancesField;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getNumberOfInstancesField() {
        return numberOfInstancesField;
    }

    public void setNumberOfInstancesField(String numberOfInstancesField) {
        this.numberOfInstancesField = numberOfInstancesField;
    }

    public String getTextCalculator() {
        return textCalculator;
    }

    public void setTextCalculator(String textCalculator) {
        this.textCalculator = textCalculator;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "textCalculator='" + textCalculator + '\'' +
                ", numberOfInstancesField='" + numberOfInstancesField + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instance instance = (Instance) o;

        if (textCalculator != null ? !textCalculator.equals(instance.textCalculator) : instance.textCalculator != null)
            return false;
        if (numberOfInstancesField != null ? !numberOfInstancesField.equals(instance.numberOfInstancesField) : instance.numberOfInstancesField != null)
            return false;
        if (firstName != null ? !firstName.equals(instance.firstName) : instance.firstName != null) return false;
        return lastName != null ? lastName.equals(instance.lastName) : instance.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = textCalculator != null ? textCalculator.hashCode() : 0;
        result = 31 * result + (numberOfInstancesField != null ? numberOfInstancesField.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
