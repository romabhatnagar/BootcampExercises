/*
Create a class Database with 2 instance variables port and name. Configure Database class bean in spring container through Spring XML. Initialize instance variables using setter method.
Get the bean of the class from spring container and print the values of the instance variable.
 */
package com.ttn.spring;

public class Database {
    private int port;
    private String name;

    @Override
    public String toString() {
        return "Database{" +
                "port=" + port +
                ", name='" + name + '\'' +
                '}';
    }

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
}
