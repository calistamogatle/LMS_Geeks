import java.util.*;

public class Library {
    private List<Book> inventory;  // Dynamic list of books
    private Book[] books;          // Fixed array of books
    private int count;             // Track the number of books in the array

    public Library(int size) {
        inventory = new ArrayList<>();  // Dynamic inventory
        books = new Book[size];         // Fixed-size array
        count = 0;
    }

    // Add and remove books (Encapsulation)
    public void addBook(Book book) {
        inventory.add(book);  // Add to dynamic inventory
        if (count < books.length) {
            books[count++] = book;  // Add to the fixed-size array
        } else {
            System.out.println("The library is full, cannot add more books.");
        }
    }

    public void removeBook(Book book) {
        inventory.remove(book);  // Remove from dynamic inventory
        for (int i = 0; i < count; i++) {
            if (books[i] == book) {
                books[i] = null;  // Remove from the fixed-size array
                break;
            }
        }
    }

    // Find a book by name
    public Book findBookByName(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null; // Book not found
    }

    // Check if a book is available
    public boolean isBookAvailable(Book book) {
        return book.isAvailable();
    }

    // Display books menu with their availability
    public void displayBooksMenu() {
        System.out.println("\nLibrary Books Menu:");
        for (int i = 0; i < count; i++) {
            if (books[i] != null) {
                String status = books[i].isAvailable() ? "Available" : "Unavailable";
                System.out.println((i + 1) + ". " + books[i].getTitle() + " - " + status);
            }
        }
    }

    // Get a book by index (with exception handling for invalid index)
    public Book getBook(int index) throws LibraryException {
        if (index < 0 || index >= count || books[index] == null) {
            throw new LibraryException("No such book exists at index: " + index);
        }
        return books[index];
    }

    // Borrow a book by any user (Polymorphism in action)
    public void borrowBook(Book book, User user) throws LibraryException {
        if (isBookAvailable(book)) {
            book.setAvailable(false);
            System.out.println(user.getName() + " borrowed " + book.getTitle());
        } else {
            throw new LibraryException("The book is unavailable.");
        }
    }

    // Return a book by any user (Polymorphism in action)
    public void returnBook(Book book, User user) throws LibraryException {
        if (!isBookAvailable(book)) {
            book.setAvailable(true);
            System.out.println(user.getName() + " returned " + book.getTitle());
        } else {
            throw new LibraryException("This book wasn't borrowed.");
        }
    }
}
