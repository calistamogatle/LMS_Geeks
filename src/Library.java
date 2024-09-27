import java.util.*;

public class Library {
    private List<Book> inventory;

    public Library() {
        inventory = new ArrayList<>();
    }

    // Add and remove books (encapsulation)
    public void addBook(Book book) {
        inventory.add(book);
    }

    public void removeBook(Book book) {
        inventory.remove(book);
    }

    // Check availability
    public boolean isBookAvailable(Book book) {
        return book.isAvailable();
    }

}
