package library.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book {
    @Id
    private Long isbn;
    private String title;
    private Integer year;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer remainingCopies;
    private Boolean registered;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Publisher publisher;

    public Book() {
    }

    public Book(Long isbn, String title, Integer year, Integer copies, Integer borrowedCopies,
                Integer remainingCopies, Boolean registered, Author author, Publisher publisher) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.copies = copies;
        this.borrowedCopies = borrowedCopies;
        this.remainingCopies = remainingCopies;
        this.registered = registered;
        this.author = author;
        this.publisher = publisher;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getBorrowedCopies() {
        return borrowedCopies;
    }

    public void setBorrowedCopies(Integer borrowedCopies) {
        this.borrowedCopies = borrowedCopies;
    }

    public Integer getRemainingCopies() {
        return remainingCopies;
    }

    public void setRemainingCopies(Integer remainingCopies) {
        this.remainingCopies = remainingCopies;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(year, book.year) && Objects.equals(copies, book.copies) && Objects.equals(borrowedCopies, book.borrowedCopies) && Objects.equals(remainingCopies, book.remainingCopies) && Objects.equals(registered, book.registered) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, year, copies, borrowedCopies, remainingCopies, registered, author, publisher);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", copies=" + copies +
                ", borrowedCopies=" + borrowedCopies +
                ", remainingCopies=" + remainingCopies +
                ", registered=" + registered +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
