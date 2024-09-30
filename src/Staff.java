public class Staff extends User {
    Library lib = Library.getInstance();

    public Staff(String staffName, String staffId, String emailId) {
        super.setUserName(staffName);
        super.setUserId(staffId);
        super.setEmailId(emailId);
    }

    public void addBook(Book book) {
        book.setAuthor(book.getAuthor());
        book.setTitle(book.getTitle());
        book.setISBN(book.getISBN());
        book.setAvailable(true);
        lib.addBook(book);
    }

    public void removeBook(String isbn) {
        lib.removeBook(isbn);
    }

}
