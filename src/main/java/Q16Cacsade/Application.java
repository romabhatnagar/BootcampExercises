package Q16Cacsade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Application {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Hibernate");
        person.setAge(23);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        person.getListOfVehicles().add(vehicle);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(person);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
