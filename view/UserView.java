package view;

import java.util.List;
import model.User;

public class UserView {
    public void displayUsers(List<? extends User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }
}