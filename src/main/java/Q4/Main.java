package Q4;

import Q4.Q4_d.CustomerManager;
import Q4.Q4_d.CustomerManagerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("Q4.xml");
//        CustomerManager customerManager = ctx.getBean(CustomerDaoImpl.class);
//        Customer cust = createDummyCustomer();
//        customerManager.createCustomer(cust);
        programmaticTransaction();
    }


    public static void programmaticTransaction() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Q4.xml");
        CustomerDAO dao = (CustomerDAO) ctx.getBean("customerDAO");
        UserServicePlatformTransaction platformTransaction = (UserServicePlatformTransaction) ctx.getBean("userServicePlatformTransaction1");
        platformTransaction.doInTransaction(dao, createDummyCustomer());
    }

    private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(3027);
        customer.setName("roma");
        Address address = new Address();
        address.setId(110043);
        address.setCountry("India");
        // setting value more than 20 chars, so that SQLException occurs
//        address.setAddress("Albany Dr, San Jose, CA 95129");
        address.setAddress("kb ");
        customer.setAddress(address);
        return customer;
    }
}
