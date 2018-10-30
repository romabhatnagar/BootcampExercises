package Q5;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeService2 {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertCustomer() {
        String sql = "INSERT INTO Employee (name,age)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"a", 29});
        throw new RuntimeException();
    }

    @Transactional
    public void insertCustomer2() {
        String sql = "INSERT INTO Employee (name,age)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"abcd", 27});

    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED, rollbackFor = RuntimeException.class)
    public void updateCustomer() throws InterruptedException {
        String sql = "Update Employee set name = ? where age = ?";
        jdbcTemplate.update(sql, new Object[]{"abc", 29});
        Thread.sleep(5000);
        throw new RuntimeException();
    }
}
