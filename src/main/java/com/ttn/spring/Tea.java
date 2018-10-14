package com.ttn.spring;

public class Tea implements HotDrink {
    @Override
    public void prepareDrink() {
        System.out.println("preparing tea");
    }
}
