package crud.update.delete;

import Entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = session.get(Author.class, 2);
        session.delete(author);
        session.getTransaction().commit();
        session.close();
        System.out.println(author);
    }
}
