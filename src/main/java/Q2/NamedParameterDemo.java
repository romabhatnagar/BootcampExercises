package Q2;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class NamedParameterDemo {
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NamedParameterDemo(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    NamedParameterDemo() {

    }

    public User namedParameterJdbcTemplateDemo() {
        String sql = "SELECT * FROM user WHERE username = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", "roma123");
        return namedParameterJdbcTemplate.queryForObject(sql, parameterSource, new UserMapper());
    }
}