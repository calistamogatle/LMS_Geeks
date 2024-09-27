public class Main {
    public static void main(String[] args) {
        // Create library
        Library library = new Library();

        // Create a librarian and a member
        Librarian librarian = new Librarian("Calista", "calista@petalmail.com" ,"password123" );
        Member member = new Member("Treasure ", "Treasure@member.com", "password123");

        // Create a book
        Book book1 = new Book("Bare", "Jackie Phamotse", "123456");

        // Librarian adds a book to the library
        librarian.addBook(book1, library);

        // Member borrows the book
        member.borrowBook(book1);

        // Check availability after borrowing
        System.out.println("Is the book available? " + library.isBookAvailable(book1));

        // Member returns the book
        member.returnBook(book1);

        // Check availability after returning
        System.out.println("Is the book available? " + library.isBookAvailable(book1));
    }

}