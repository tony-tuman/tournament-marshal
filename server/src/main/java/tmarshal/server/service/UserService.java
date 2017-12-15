package tmarshal.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tmarshal.model.User;
import tmarshal.model.SparseUser;
import tmarshal.server.dao.UserDao;
import tmarshal.server.exceptions.UnauthorizedAccessException;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void create (String userName) {
        User user = new User();
        user.setUserName(userName);
        userDao.insertUser(user);
    }

    public User findByUserName(String userName) throws UnauthorizedAccessException {
        User specifiedUser = userDao.findUserByName(userName);
        specifiedUser.verifyAuthority();
        return specifiedUser;
    }

    public void delete(String userName) throws UnauthorizedAccessException {
        User specifiedUser = userDao.findUserByName(userName);
        specifiedUser.verifyAuthority();
        userDao.deleteUserByName(userName);
    }

}

