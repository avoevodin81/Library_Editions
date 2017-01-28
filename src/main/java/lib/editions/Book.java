package lib.editions;

import lib.Books;
import lib.Edition;

import java.util.Date;

public class Book extends Books {
    private String author;
    private String publisher;

    public Book(String name, int pageQuantity, String author, String publisher, Date year) {
        super(name, pageQuantity, year);
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public void printInformation() {
        System.out.println(String.format("%s {name='%s', pageQuantity='%d', author='%s', publisher='%s', year='%d'",
                getClass().getSimpleName(), getName(), getPageQuantity(), getAuthor(), getPublisher(), getYear().getYear()));
    }

    public int compareTo(Edition o) {
        int result = super.compareTo(o);
        if (result != 0) {
            return result;
        }
        if (o instanceof Book) {
            Book book = (Book) o;
            result = getAuthor().compareTo(book.getAuthor());
            if (result != 0) {
                return result;
            }
            result = getPublisher().compareTo(book.getPublisher());
            if (result != 0) {
                return result;
            }
        }

        return 0;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
