public class Librarian extends User{
    public Librarian(String name, String email,  String password) {
        super(name, email, password);
    }

    // Librarian specific methods
    public void addBook(Book book, Library library) {
        library.addBook(book);
        System.out.println("Librarian added: " + book);
    }

    public void removeBook(Book book, Library library) {
        library.removeBook(book);
        System.out.println("Librarian removed: " + book);
    }

    public void borrowBook(Book book) {
        book.borrow();
    }

    public void returnBook(Book book) {
        book.returnItem();
    }

}

