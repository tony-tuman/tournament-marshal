package tmarshal.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tmarshal.model.SparseUser;
import tmarshal.server.mapper.SparseUserRowMapper;

import java.util.Collection;

@Service
public class SparseUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public Collection<SparseUser> getAllUsers() {
        String sql = "select key, userName, firstName, lastName from users";
        return jdbcTemplate.query(sql, new SparseUserRowMapper());
    }
}
