package model;

public class Teacher extends User {
    public Teacher(int id, String firstName, String lastName, String secondName) {
        super(id, firstName, lastName, secondName);
    }

    @Override
    public Type getUserType() {
        return Type.TEACHER;
    }
}