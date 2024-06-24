package controller;

import java.util.List;

import model.Student;
import model.StudyGroup;
import model.Teacher;
import model.Type;
import service.UserGroupService;
import service.UserService;
import view.UserView;

public class UserController {
    private UserService userService = new UserService();
    private UserGroupService userGroupService = new UserGroupService();
    private UserView userView = new UserView();

    public void createStudent(String firstName, String secondName, String lastName) {
        userService.createUser(Type.STUDENT, firstName, secondName, lastName);
    }

    public void createTeacher(String firstName, String secondName, String lastName) {
        userService.createUser(Type.TEACHER, firstName, secondName, lastName);
    }

    public StudyGroup createStudyGroup(int teacherId, List<Integer> studentIds) {
        Teacher teacher = userGroupService.getTeacherById(teacherId);
        if (teacher == null) {
            System.out.println("Учитель с ID " + teacherId + " не найден");
            return null;
        }

        List<Student> students = userGroupService.getStudentsByIds(studentIds);
        if (students.isEmpty()) {
            System.out.println("Студенты по предоставленным идентификаторам не найдены");
            return null;
        }

        StudyGroup studyGroup = new StudyGroup(teacher, students);
        System.out.println("Study Group created: " + studyGroup);
        return studyGroup;
    }

    public void printAllStudents() {
        userView.displayUsers(userService.getAllStudents());
    }

    public void printAllTeachers() {
        userView.displayUsers(userService.getAllTeachers());
    }

    public void updateUserName(int userId, String firstName, String secondName, String lastName) {
        userService.updateUser(userId, firstName, secondName, lastName);
    }
}
