package am.tech42.onlineshop.service;

import am.tech42.onlineshop.model.User;

import java.util.Collections;
import java.util.List;

public class UserService {

    private static List<User> users = Collections.singletonList(
            new User(1, "+37495914536", "test")
    );

    public static User login(String phoneNumber, String password) {
        for (User user : users) {
            if(user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

}
