package Q4.Q4_d;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Q4.xml");
    CustomerService customerService = applicationContext.getBean(Q4.Q4_d.CustomerService.class);


}
