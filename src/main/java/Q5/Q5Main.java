package Q5;

import Q3.Author3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Q5Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Author3 author = new Author3();
        author.setFirstName("First Author");
        author.setLastName("First Name");
        author.setId(1);
        author.setAge(20);
        author.setDob(new Date());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(author);
        tx.commit();
        sessionFactory.close();
        session.close();

    }
}