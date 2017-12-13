package tmarshal.server.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tmarshal.model.User;
import tmarshal.model.SparceUser;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private HashMap<String, User> users;
    private Integer nextId = 0;

    @PostConstruct
    private void loadUser() {
        users = new HashMap<>();
        createUser("tom");
        createUser("jerry");
        createUser("tony");
    }

    public void createUser (String userName) {
        nextId++;
        users.put(nextId.toString(), new User(nextId, userName));
    }


    public void verifyAuthority(User specifiedUser) throws Exception {
        SimpleGrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ROLE_ADMIN");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName().equals(specifiedUser.getUserName()) ||
            auth.getAuthorities().contains(ADMIN_AUTHORITY)) {
            throw new Exception("Get the heck outta here!!!!");
        }
    }

    public User findById(String id) throws Exception {
        User specifiedUser = users.get(id);
        verifyAuthority(specifiedUser);
        return specifiedUser;
    }

    public void deleteById(String id) throws Exception {
        User specifiedUser = users.get(id);
        verifyAuthority(specifiedUser);
        users.remove(id);
    }

    public void addUser(User user) {
        createUser(user.getUserName());
    }

    public Collection<SparceUser> getAllUsers(){
        HashSet <SparceUser> returnSet = new HashSet();
        for (User user : users.values()) {
            returnSet.add(new SparceUser(user));
        }
        return returnSet;
    }
}

