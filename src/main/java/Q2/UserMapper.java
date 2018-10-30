package Q2;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setAge(Integer.parseInt(rs.getString("age")));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setDob(rs.getString("dob"));
        return user;
    }
}
