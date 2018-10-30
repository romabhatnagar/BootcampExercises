package Q3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Q3.xml");
        HibernateEx hibernate = applicationContext.getBean(HibernateEx.class);
        hibernate.sessionFactoryDemo();
    }
}
