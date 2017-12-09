package tmarshal.server.service;

import org.springframework.stereotype.Service;
import tmarshal.model.User;
import tmarshal.model.SparceUser;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private HashSet<User> users;

    @PostConstruct
    private void loadUser() {
        users = new HashSet<>();
        users.add(new User(1,"Tom"));
        users.add(new User(2,"Jerry"));
    }

    public Optional<User> findById(String id) {
        return users.stream().filter(user -> user.getKey().equals(id)).findFirst();
    }

    public Collection<SparceUser> getAllUsers(){
        return users.stream().map(SparceUser::new).collect(Collectors.toList());
    }
}

