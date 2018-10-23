package crud.update;

import Entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyMain {
    public static void main(String[] args) {
        Author author = new Author();
        author.setFirstName("Hibernate");
        author.getLastName();
        author.setAge(27);
        author.setId(2);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }
}
