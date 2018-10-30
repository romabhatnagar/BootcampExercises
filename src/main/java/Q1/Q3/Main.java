package Q1.Q3;

import com.mysql.jdbc.PreparedStatement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

    //question 1.3 all ways and 1.4
    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Q1_3.xml");
        SpringJDBC springJDBC1 = applicationContext.getBean("myBean1", SpringJDBC.class);
        SpringJDBC springJDBC2 = applicationContext.getBean("myBean2", SpringJDBC.class);
        SpringJDBC springJDBC3 = applicationContext.getBean("myBean3", SpringJDBC.class);
        springJDBC1.preparedStatement();
        springJDBC2.preparedStatement();
        springJDBC3.preparedStatement();
    }
}
