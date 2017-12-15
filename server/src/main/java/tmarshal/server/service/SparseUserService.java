package tmarshal.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmarshal.model.SparseUser;
import tmarshal.model.User;
import tmarshal.server.dao.SparseUserDao;
import tmarshal.server.dao.UserDao;
import tmarshal.server.exceptions.UnauthorizedAccessException;

import java.util.Collection;

@Service
public class SparseUserService {

    @Autowired
    SparseUserDao sparseUserDao;

    public Collection<SparseUser> findAll() throws UnauthorizedAccessException {
        return sparseUserDao.getAllUsers();
    }

    public SparseUser getUserByName(String userName) throws UnauthorizedAccessException {
        return sparseUserDao.getUserByName(userName);
    }
}

