package tmarshal.server.mapper;

import org.springframework.jdbc.core.RowMapper;
import tmarshal.model.PostalAddress;
import tmarshal.model.SparseUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostalAddressRowMapper implements RowMapper<PostalAddress>{

    @Override
    public PostalAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostalAddress address = new PostalAddress();
        address.setKey(rs.getInt("key"));
        address.setAddressLine1(rs.getString("addressLine1"));
        address.setAddressLine2(rs.getString("addressLine2"));
        address.setCity(rs.getString("city"));
        address.setPostalCode(rs.getString("postalCode"));
        address.setCountry(rs.getString("country"));
        return address;
    }
}
