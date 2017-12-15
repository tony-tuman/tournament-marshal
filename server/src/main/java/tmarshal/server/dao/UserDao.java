package tmarshal.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import tmarshal.model.User;
import tmarshal.server.mapper.UserRowMapper;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public User findUserByName(String userName) {
        String sql = "select * from Users where userName = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userName}, new UserRowMapper());
    }

    @Transactional(readOnly=false)
    public void deleteUserByName(String userName) {
        String sql = "delete from Users where userName = ?";
        jdbcTemplate.update(sql, new Object[]{userName});
    }

    @Transactional(readOnly=false)
    public void updateUserByName(User user) {
        String sql = "update Users ('userName', 'firstName', 'lastName', 'password', 'email', 'emailVerified', 'roles') values (?,?,?,?,?,?,?) where key = ?";
        jdbcTemplate.update(sql, new Object[]{user.getUserName(), user.getFirstName(), user.getLastName(),
                                              user.getEmail(), user.getEmailVerified(), user.getRoles()});
    }

    @Transactional(readOnly=false)
    public void insertUser(User user) {
        String sql = "insert into Users ('userName', 'firstName', 'lastName', 'password', 'email', 'emailVerified', 'roles') values (?,?,?,?,?,?,?) where key = ?";
        jdbcTemplate.update(sql, new Object[]{user.getUserName(), user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getEmailVerified(), user.getRoles()});
    }
}
