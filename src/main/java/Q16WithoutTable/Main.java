package Q16WithoutTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Author16 author = new Author16();
        author.setAge(23);
        author.setId(2);
        author.setFirstName("roma");
        author.setLastName("bhatnagar");

        Book16 book16 = new Book16();
        book16.setBookName("java ee");
        Book16 book1 = new Book16();
        book1.setBookName("hibernate");
        book1.setAuthor16(author);
        session.save(book16);
        session.save(book1);

        List<Book16> book16List = new ArrayList();
        book16List.add(book16);
        book16List.add(book1);

        author.setBook16(book16List);
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }
}
