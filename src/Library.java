import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
private static Library library;
private Library() {
}

public static Library getInstance() {
    if (library == null) {
        library = new Library();
    }
    return library;
}
    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book with ISBN: " + isbn + " removed.");
        } else {
            System.out.println("Book with ISBN: " + isbn + " does not exist.");
        }
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book with title: " + title + " not found.");
        return null;
    }



    public List<Book> getAllBooks() {
        return books;
    }
}
