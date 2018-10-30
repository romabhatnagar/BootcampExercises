package Q2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Q2.xml");
        CustomJDBCTemplate customJDBCTemplate = applicationContext.getBean("myBean4", CustomJDBCTemplate.class);
        customJDBCTemplate.countUsers();
        String userName = customJDBCTemplate.getUserName();
        System.out.println(userName);

        User user = applicationContext.getBean("myBean5", User.class);
        customJDBCTemplate.insertRecords(user);
        customJDBCTemplate.queryMap();
        customJDBCTemplate.queryList();
        User user1 = customJDBCTemplate.getUser();
        System.out.println("this is user data " + user1);

        NamedParameterDemo nm = applicationContext.getBean("myBean6", NamedParameterDemo.class);
        User user2 = nm.namedParameterJdbcTemplateDemo();
        System.out.println("user " + user2);
    }
}
