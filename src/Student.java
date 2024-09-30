import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    List<Book> borrowedBooks = new ArrayList<>();

    public Student(String studentName, String userId, String emailId) {
        super.setUserName(studentName);
        super.setUserId(userId);
        super.setEmailId(emailId);
    }

    public void borrowBook(String title) {
        Book b = Library.getInstance().searchBook(title);
        if (b != null && b.isAvailable()) {
            System.out.println("Borrowed the book: ");
            System.out.println(b);
            b.setAvailable(false);
            borrowedBooks.add(b);
        } else {
            System.out.println("Book unavailable for borrowing.");
        }
    }

    public List<Book> myBorrowedBooks() {
        return borrowedBooks;
    }

    public void returnBook(String title) {
        Book bookToReturn = null;
        for (Book book : borrowedBooks) {
            if (book.getTitle().equals(title)) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn != null) {
            bookToReturn.setAvailable(true);
            borrowedBooks.remove(bookToReturn);
            System.out.println("Book '" + title + "' has been returned successfully.");
        } else {
            System.out.println("You haven't borrowed the book '" + title + "'.");
        }
    }

}
