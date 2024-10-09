import static java.lang.Character.getName;

public class Librarian extends User {

    public Librarian(String name, String email, String password) {
        super(name, email, password);
    }

    // Perform an action (polymorphism in action)
    @Override
    public void performAction(Library library, Book book, String action) {
        switch (action.toLowerCase()) {
            case "borrow":
                borrowBook(book, library);
                break;
            case "return":
                returnBook(book, library);
                break;
            case "add":
                addBook(book, library);
                break;
            case "remove":
                removeBook(book, library);
                break;
            default:
                System.out.println("Invalid action for a librarian.");
        }
    }

    // Librarians can add books to the library
    public void addBook(Book book, Library library) {
        library.addBook(book);
        System.out.println(getName() + " added the book: " + book.getTitle());
    }

    // Librarians can remove books from the library
    public void removeBook(Book book, Library library) {
        library.removeBook(book);
        System.out.println(getName() + " removed the book: " + book.getTitle());
    }

    // Librarian can also borrow books
    public void borrowBook(Book book, Library library) {
        try {
            library.borrowBook(book, this);  // Using polymorphism to borrow books
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }
    }

    // Librarian can return books
    public void returnBook(Book book, Library library) {
        try {
            library.returnBook(book, this);  // Using polymorphism to return books
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }
    }
}

