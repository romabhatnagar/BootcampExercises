package com.ttn.springBoot.SpringBootExercise;

public class Database {
    private int port;
    private String name;

    Database(){

    }

    public Database(int port, String name) {
        this.port = port;
        this.name = name;
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
