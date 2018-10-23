package Q10_11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Address address = new Address();
        address.setLocation("noida");
        address.setState("noida");
        address.setStreetNumber("1038");

        Author10 author10 = new Author10();
        author10.setAge(29);
        author10.setFirstName("roma2");
        author10.setLastName("bhatnagar");
        author10.setAddress(address);
        session.beginTransaction();
        session.save(author10);
        session.getTransaction().commit();
        session.close();


    }
}
