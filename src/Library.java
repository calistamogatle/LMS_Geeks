import java.util.*;

public class Library {
    private List<Book> inventory;
    private Book[] books;  // Array to store books - size 10
    private int count;

    public Library(int size) {
        inventory = new ArrayList<>();
        books = new Book[size];  // Initialize the array with a specific size
        count = 0;
    }

    // Add and remove books (encapsulation)
    public void addBook(Book book) {
        inventory.add(book);
        if (count < books.length) {
            books[count] = book;
            count++;
        } else {
            System.out.println("The library is full, cannot add more books.");
        }

    }

    public void removeBook(Book book) {
        inventory.remove(book);
    }

    // Find a book by name
    public Book findBookByName(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null; // Book not found
    }

    // Check availability
    public boolean isBookAvailable(Book book) {
        return book.isAvailable();
    }

    public void displayBooksMenu() {
        System.out.println("\nLibrary Books Menu:");
        for (int i = 0; i < count; i++) {
            String status = books[i].isAvailable() ? "Available" : "Unavailable";
            System.out.println((i + 1) + ". " + books[i].getTitle() + " - " + status);
        }
    }
    // Get a book by index (with exception handling for invalid index)
    public Book getBook(int index) throws LibraryException {
        if (index < 0 || index >= count) {
            throw new LibraryException("No such book exists at index: " + index);
        }
        return books[index];
    }
}

