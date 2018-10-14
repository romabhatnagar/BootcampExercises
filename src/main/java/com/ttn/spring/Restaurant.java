package com.ttn.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

interface HotDrink {
    void prepareDrink();
}

public class Restaurant {
    @Qualifier("expressTea")
    @Autowired
    private HotDrink hotDrink;

    @Autowired
    public Restaurant(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    public HotDrink getHotDrink() {
        return hotDrink;
    }

    @Required
    @Autowired
    public void setHotDrink(HotDrink HotDrink) {
        this.hotDrink = hotDrink;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "hotDrink=" + hotDrink +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("MainXML.xml");
        Restaurant restaurant = applicationContext.getBean("expTea", Restaurant.class);
        Restaurant restaurant1 = applicationContext.getBean("teaRestaurant", Restaurant.class);
        restaurant.getHotDrink().prepareDrink();
        restaurant1.getHotDrink().prepareDrink();

        //when there is only one bean present
       /* Restaurant restaurant2 = applicationContext.getBean(Restaurant.class);
        restaurant2.getHotDrink().prepareDrink();*/

        //checking scope
        System.out.println(restaurant == restaurant1);


        /* uncomment for autowire by name
        Restaurant restaurant = applicationContext.getBean(Restaurant.class);
        restaurant.getHotDrink().prepareDrink();
       */

        /*uncomment for autowire by type
        Restaurant restaurant = applicationContext.getBean(Restaurant.class);
        restaurant.getHotDrink().prepareDrink();*/

      /*  uncomment for autowire by constructor
        Restaurant restaurant = applicationContext.getBean(Restaurant.class);
        restaurant.getHotDrink().prepareDrink();*/
    }

}
