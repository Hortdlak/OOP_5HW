package model;

public abstract class User {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String secondName;

    protected User(int id, String firstName, String lastName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public abstract Type getUserType();

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", secondName=" + secondName + "]";
    }
}
