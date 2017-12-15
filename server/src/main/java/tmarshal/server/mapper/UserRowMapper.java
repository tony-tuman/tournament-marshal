package tmarshal.server.mapper;

import org.springframework.jdbc.core.RowMapper;
import tmarshal.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setKey(rs.getInt("key"));
        user.setEmail(rs.getString("email"));
        user.setUserName(rs.getString("userName"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setPassword(rs.getString("password"));
        user.setEmailVerified(rs.getBoolean("emailVerified"));
        user.setRoles(rs.getString("roles"));
        return user;
    }
}
