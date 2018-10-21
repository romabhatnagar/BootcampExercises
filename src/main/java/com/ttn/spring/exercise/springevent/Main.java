package com.ttn.spring.exercise.springevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("databaseConfig.xml");
        Database database = applicationContext.getBean(Database.class);
        System.out.println(database);
        database.connect();
        System.out.println("Connection closed ?" + database.closeConnection());
        database.throwException();

        ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext("databaseConfig.xml");
        configurableApplicationContext.refresh();
        configurableApplicationContext.start();
        configurableApplicationContext.stop();
        configurableApplicationContext.close();
    }
}
