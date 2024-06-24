package model;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        int result = o1.getSecondName().compareTo(o2.getSecondName());
        if (result == 0) {
            result = o1.getFirstName().compareTo(o2.getFirstName());
            if (result == 0) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        }
        return result;
    }
}