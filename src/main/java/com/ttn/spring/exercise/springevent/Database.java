package com.ttn.spring.exercise.springevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class Database implements ApplicationEventPublisherAware {
    private int port;
    private String name;
    ApplicationEventPublisher applicationEventPublisher;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void connect() {
        CustomEvent customEvent = new CustomEvent(this);
        applicationEventPublisher.publishEvent(customEvent);
        System.out.println("database is now connected");
    }

    Boolean closeConnection() {
        return true;
    }

    void throwException() throws Exception {
        throw new Exception();
    }

    @Override
    public String toString() {
        return "Database{" +
                "port=" + port +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
