public class Member extends User  {

    public Member(String name, String email, String password) {
        super(name,email,password);
    }

    @Override
    public void performAction(Library library, Book book, String action) {
        if (action.equalsIgnoreCase("borrow")) {
            try {
                borrowBook(book, library);
            } catch (LibraryException e) {
                throw new RuntimeException(e);
            }
        } else if (action.equalsIgnoreCase("return")) {
            try {
                returnBook(book, library);
            } catch (LibraryException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Invalid action for a member.");
        }
    }

    public void borrowBook(Book book, Library library) throws LibraryException {
        if (library.isBookAvailable(book)) {
            library.borrowBook(book, this);
            System.out.println(getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is unavailable.");
        }
    }


    public void returnBook(Book book, Library library) throws LibraryException {
        library.returnBook(book, this);
        System.out.println(getName() + " returned " + book.getTitle());
    }

    public boolean login(String email, String password) {

        return false;
    }
}
