package Q7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Author2 author = new Author2();
        author.setAge(25);
        author.setFirstName("abc");
        author.setLastName("xyz");
        author.setId(6);
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }
}
