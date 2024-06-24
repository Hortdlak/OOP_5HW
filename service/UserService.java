package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void createUser(Type type, String firstName, String secondName, String lastName) {
        int id = getNextId(type);
        User user;
        if (type == Type.STUDENT) {
            user = new Student(id, firstName, lastName, secondName);
        } else if (type == Type.TEACHER) {
            user = new Teacher(id, firstName, lastName, secondName);
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
        users.add(user);
    }

    private int getNextId(Type type) {
        return users.stream()
                .filter(u -> (type == Type.STUDENT && u instanceof Student) ||
                             (type == Type.TEACHER && u instanceof Teacher))
                .mapToInt(User::getId)
                .max()
                .orElse(0) + 1;
    }

    public Student getStudentById(int id) {
        return users.stream()
                .filter(user -> user instanceof Student && user.getId() == id)
                .map(user -> (Student) user)
                .findFirst()
                .orElse(null);
    }

    public Teacher getTeacherById(int id) {
        return users.stream()
                .filter(user -> user instanceof Teacher && user.getId() == id)
                .map(user -> (Teacher) user)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAllStudents() {
        return users.stream()
                .filter(Student.class::isInstance)
                .map(Student.class::cast)
                .collect(Collectors.toList());
    }

    public List<Teacher> getAllTeachers() {
        return users.stream()
                .filter(Teacher.class::isInstance)
                .map(Teacher.class::cast)
                .collect(Collectors.toList());
    }

    public void updateUser(int userId, String firstName, String secondName, String lastName) {
        Optional<User> optionalUser = users.stream().filter(u -> u.getId() == userId).findFirst();
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (firstName != null) user.setFirstName(firstName);
            if (secondName != null) user.setSecondName(secondName);
            if (lastName != null) user.setLastName(lastName);
        }
    }
}
