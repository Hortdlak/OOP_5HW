package model;

import java.util.List;

public class StudyGroup {
    private Teacher teacher;
    private List <Student> students;
    public  StudyGroup(Teacher teacher, List<Student> students){
        this.teacher = teacher;
        this.students = students;

    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public List<Student> getStudents() {
        return students;
    }
}
