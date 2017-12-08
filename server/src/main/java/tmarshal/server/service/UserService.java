package tmarshal.server;

import org.springframework.stereotype.Service;
import tmarshal.model.User;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> users;

    @PostConstruct
    private void loadUser() {
        users = new HashMap<>();
        users.put("1", new User("Tom"));
        users.put("2", new User("Jerry"));
    }

    public User findById(String id) {
        return users.get(id);
    }
}

