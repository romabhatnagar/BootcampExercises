package Q5;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeService {

    private JdbcTemplate jdbcTemplate;

    private EmployeeService2 employeeService2;

    public EmployeeService2 getEmployeeService2() {
        return employeeService2;
    }

    public void setEmployeeService2(EmployeeService2 employeeService2) {
        this.employeeService2 = employeeService2;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Transactional
    public void insertCustomer() throws InterruptedException {
        Thread.sleep(5000);
        String sql = "INSERT INTO Employee (name,age)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"roma", 23});
        try {
            employeeService2.insertCustomer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            employeeService2.insertCustomer2();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void readEmployee() throws InterruptedException {
        Thread.sleep(2000);
        String sql = "SELECT * FROM Employee WHERE age = ?";
        System.out.println(jdbcTemplate.queryForMap(sql, new Object[]{29}));

    }


}
