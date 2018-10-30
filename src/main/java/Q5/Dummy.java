package Q5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Dummy {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Q5.xml");
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        employeeService.insertCustomer();
        System.out.println("Finished");

    }
}
