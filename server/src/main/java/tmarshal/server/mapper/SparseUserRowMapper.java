package tmarshal.server.mapper;

import org.springframework.jdbc.core.RowMapper;
import tmarshal.model.SparseUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SparseUserRowMapper implements RowMapper<SparseUser> {

    @Override
    public SparseUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            SparseUser user = new SparseUser();
            user.setKey(rs.getInt("key"));
            user.setUserName(rs.getString("userName"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            return user;
        }
}
