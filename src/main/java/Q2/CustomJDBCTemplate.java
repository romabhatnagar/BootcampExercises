package Q2;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomJDBCTemplate {
    JdbcTemplate jdbcTemplate;

    public CustomJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void countUsers() {
        System.out.println("Count of users: " + jdbcTemplate.queryForObject("select count(*) from user", Integer.class));
    }

    public String getUserName() {

        String sql = "Select name from user where username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{"roma123"}, String.class);
    }

    public void insertRecords(User user) {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        //update is used for both insert,update and delete
        jdbcTemplate.update(sql, new Object[]{user.getUsername(), user.getPassword(), user.getName(),
                user.getAge(), user.getDob()});
    }

    public void queryMap() {
        String sql = "SELECT * FROM user WHERE username = ?";
        System.out.println("Query map " + jdbcTemplate.queryForMap(sql, new Object[]{"roma123"}));
    }

    public void queryList() {
        String sql = "SELECT * FROM user";
        System.out.println("Query list " + jdbcTemplate.queryForList(sql));
    }

    public User getUser() {
        String sql = "SELECT * FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{"roma123"}, new UserMapper());
    }
}
