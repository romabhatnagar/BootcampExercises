package com.ttn.spring;

public class ExpressTea implements HotDrink {
    @Override
    public void prepareDrink() {
        System.out.println("preparing express tea");
    }
}
