package com.ttn.spring.exercise.Q7;

import com.ttn.spring.exercise.springevent.Database;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("databaseConfig.xml");
        Database database = ctx.getBean(Database.class);
        System.out.println("---");
        MultiEventListener multiEventListener = ctx.getBean(MultiEventListener.class);
        multiEventListener.start();
        multiEventListener.stopped();
        multiEventListener.refreshed();
    }
}
