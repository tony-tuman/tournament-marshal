package tmarshal.server.service;

import org.springframework.stereotype.Service;
import tmarshal.model.User;
import tmarshal.model.SparceUser;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private HashMap<String, User> users;

    @PostConstruct
    private void loadUser() {
        users = new HashMap<>();
        users.put("1", new User(1,"tom"));
        users.put("2", new User(2,"jerry"));
        users.put("3", new User(3, "tony"));
    }

    public User findById(String id) {
        return users.get(id);
    }

    public Collection<SparceUser> getAllUsers(){
        HashSet <SparceUser> returnSet = new HashSet();
        for (User user : users.values()) {
            returnSet.add(new SparceUser(user));
        }
        return returnSet;
    }
}

