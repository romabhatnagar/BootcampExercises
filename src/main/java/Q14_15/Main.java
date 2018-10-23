package Q14_15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Book book = new Book();
        book.setBookName("Java Core");
        session.save(book);
        Author15 author = new Author15();
        author.setAge(23);
        author.setId(2);
        author.setFirstName("roma");
        author.setLastName("bhatnagar");
        author.setBook(book);
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }
}
