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
        if (isBorrowingAllowed()) {
            Book b = Library.getInstance().searchBook(title);
            if (b != null && b.isAvailable()) {
                System.out.println("Borrowed the book: ");
                System.out.println(b);
                b.setAvailable(false);
                borrowedBooks.add(b);
            } else {
                System.out.println("Book unavailable for borrowing.");
            }
        } else {
            System.out.println("You already have " + borrowedBooks.size() + " books borrowed. " +
                    "A student can only borrow 3 books at a time. Please return some books to borrow again.");
        }
    }

    private boolean isBorrowingAllowed() {
        return this.borrowedBooks.size() < 3;
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
