import controller.UserController;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        UserController controller = new UserController();

        controller.createStudent("John", "Doe", "Smith");
        controller.createStudent("Alice", "Smith", "Johnson");
        controller.createStudent("Bob", "Johnson", "Brown");

        controller.createTeacher("Jane", "Doe", "Smith");
        controller.createTeacher("Michael", "Johnson", "Brown");

        controller.createStudyGroup(1, Arrays.asList(1, 2));
        controller.createStudyGroup(2, Arrays.asList(2, 3)); 

           
    }
}