package Q3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Author3 author3 = new Author3();
        author3.setAge(25);
        author3.setFirstName("abcd");
        author3.setLastName("hfi");
        author3.setDob(new Date(1995 - 11 - 9));
        session1.beginTransaction();
        session1.save(author3);
        session1.getTransaction().commit();
        session1.close();

    }
}
