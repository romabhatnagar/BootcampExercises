package com.ttn.spring.exercise.springevent;

import org.springframework.context.ApplicationListener;

public class Listener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("This event is fired by :" + event.getSource());
    }
}

