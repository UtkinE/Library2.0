package net.utkine.library.form;

import javax.persistence.*;

//import net.utkine.library.form.Author;

@Entity
@Table(name="book")
public class Book {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_book;

    @Column(name = "nameBook")
    private String nameBook;

    @Column(name = "datePublic")
    private String datePublic;

    @Column(name = "genre")
    private String genre;

    @Column(name = "authorid")
    private Integer authorid;

    public Integer getId_book() {
        return id_book;
    }

    public void setId_book(Integer id_book) {
        this.id_book = id_book;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getDatePublic() {
        return datePublic;
    }

    public void setDatePublic(String datePublic) {
        this.datePublic = datePublic;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @ManyToOne
    @JoinColumn(name = "id_author")
    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }
}

