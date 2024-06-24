package model;

public class Student extends User {
    public Student(int id, String firstName, String lastName, String secondName) {
        super(id, firstName, lastName, secondName);
    }

    @Override
    public Type getUserType() {
        return Type.STUDENT;
    }
}