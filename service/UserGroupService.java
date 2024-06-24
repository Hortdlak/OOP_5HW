package service;

import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class UserGroupService {
    private UserService userService = new UserService();

    public Teacher getTeacherById(int id) {
        return userService.getTeacherById(id);
    }

    public List<Student> getStudentsByIds(List<Integer> ids) {
        List<Student> students = new ArrayList<>();
        for (int id : ids) {
            Student student = userService.getStudentById(id);
            if (student != null) {
                students.add(student);
            }
        }
        return students;
    }
    
}
