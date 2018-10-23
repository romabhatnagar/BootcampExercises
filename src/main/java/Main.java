import Entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //create operation
        Author author = new Author();
        author.setAge(23);
        author.setId(2);
        author.setFirstName("roma");
        author.setLastName("bhatnagar");
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();

        //read operation

        Author author1 = session.get(Author.class, 0);
        session.getTransaction().commit();
//        session.close();
        System.out.println("author details " + author1);

    }
}
