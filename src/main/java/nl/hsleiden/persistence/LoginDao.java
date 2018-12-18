package nl.hsleiden.persistence;

import nl.hsleiden.model.LoginUser;
import nl.hsleiden.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoginDao {
    private final List<LoginUser> users;

    public LoginDao(){
        LoginUser loginUser = new LoginUser();
        loginUser.setEmail("jaccoberg2281@gmail.com");
        loginUser.setPassword("oof");

        users = new ArrayList<>();
        users.add(loginUser);
    }

    public LoginUser getUser(String email){
        Optional<LoginUser> result = users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();

        return result.isPresent()
                ? result.get()
                : null;
    }
}
