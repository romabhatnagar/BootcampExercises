package crud.update;

import Entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session;
        session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = session.get(Author.class, 2);
        author.setFirstName("Updated Name");
        session.update(author);
        session.getTransaction().commit();
        session.close();
        System.out.println(author);
    }
}
