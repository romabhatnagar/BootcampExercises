package Q16Bidirectional;

import javax.persistence.*;

@Entity
public class Book16 {
    private String bookName;
    @ManyToOne
    private Author16 author16;

    public Author16 getAuthor16() {
        return author16;
    }

    public void setAuthor16(Author16 author16) {
        this.author16 = author16;
    }

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
