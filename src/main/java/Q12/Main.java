package Q12;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Author12 author = new Author12();
//        session.persist(author); q13
        author.setAge(23);
        author.setId(2);
        author.setFirstName("roma");
        author.setLastName("bhatnagar");
        List<String> list = new ArrayList();
        list.add("java");
        list.add("pascal");
        list.add("C");
        list.add("ruby");

        author.setSubjectsList(list);
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }
}
