package tmarshal.server.mapper;

import org.springframework.jdbc.core.RowMapper;
import tmarshal.model.PostalAddress;
import tmarshal.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setPostalAddress(new PostalAddress());
        user.setKey(rs.getInt("key"));
        user.setEmail(rs.getString("email"));
        user.setUserName(rs.getString("userName"));
        user.setFullName(rs.getString("fullName"));
        user.setPassword(rs.getString("password"));
        user.setEmailVerified(rs.getBoolean("emailVerified"));
        user.setRoles(rs.getString("roles"));
        user.getPostalAddress().setAddressLine1(rs.getString("addressLine1"));
        user.getPostalAddress().setAddressLine2(rs.getString("addressLine2"));
        user.getPostalAddress().setCity(rs.getString("city"));
        user.getPostalAddress().setState(rs.getString("state"));
        user.getPostalAddress().setPostalCode(rs.getString("postalCode"));
        user.getPostalAddress().setCountry(rs.getString("country"));
        return user;
    }
}
