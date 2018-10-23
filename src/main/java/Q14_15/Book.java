package Q14_15;

import javax.persistence.*;

@Entity
public class Book {
    private String bookName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
