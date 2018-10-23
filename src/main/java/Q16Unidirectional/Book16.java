package Q16Unidirectional;

import javax.persistence.*;

@Entity
public class Book16 {
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
