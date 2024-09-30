public class Main {
    public static void main(String[] args) {
        Library lib = Library.getInstance();
        Student s1 = new Student("Student1", "13cs076", "hytejasvi");
        Staff staff = new Staff("Staff1", "st1", "st1@amail.com");

        // Creating books directly using the constructor
        Book b1 = new Book("The Secret", "Rhonda Byrne", "SEC01");
        Book b2 = new Book("Clean Code", "Robert Martin", "CC01");

        // Adding books to the library
        staff.addBook(b1);
        staff.addBook(b2);

        // Display all books in the library
        System.out.println(lib.getAllBooks());

        // Student borrows a book
        s1.borrowBook("The Secret");
        s1.borrowBook("Clean Code");

        // Display all books after borrowing
        System.out.println(lib.getAllBooks());

        // Display borrowed books by the student
        System.out.println("my borrowed books are : ");
        System.out.println(s1.myBorrowedBooks());

        s1.returnBook("Clean Code");
        System.out.println("my borrowed books are : ");
        System.out.println(s1.myBorrowedBooks());
    }
}
