package tmarshal.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import tmarshal.model.PostalAddress;
import tmarshal.model.SparseUser;
import tmarshal.server.mapper.PostalAddressRowMapper;

import java.util.Collection;

public class PostalAddressDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public Collection<PostalAddress> getAllUsers() {
        String sql = "select key, addressLine1, addressLine2, city, postalCode, country from postal-codes";
        return jdbcTemplate.query(sql, new PostalAddressRowMapper());
    }
}
