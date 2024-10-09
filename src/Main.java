import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LibraryException {
        // Create library
        Library library = new Library(10);

        // Create a librarian and a member
        Librarian librarian = new Librarian("Calista", "calista@petalmail.com", "password123");
        Member member = new Member("Treasure", "Treasure@gmail.com", "password1234");

        // Create books
        Book book1 = new Book("Bare");
        Book book2 = new Book("The Great Gatsby");
        Book book3 = new Book("1984");
        Book book4 = new Book("Pride and Prejudice");
        Book book5 = new Book("Animal Farm");
        Book book6 = new Book("War and Peace");
        Book book7 = new Book("A Tale of Two Cities");
        Book book8 = new Book("Brave New World");
        Book book9 = new Book("Oliver Twist");
        Book book10 = new Book("Persuasion");

        // Librarian adds books to the library
        librarian.addBook(book1, library);
        librarian.addBook(book2, library);
        librarian.addBook(book3, library);
        librarian.addBook(book4, library);
        librarian.addBook(book5, library);
        librarian.addBook(book6, library);
        librarian.addBook(book7, library);
        librarian.addBook(book8, library);
        librarian.addBook(book9, library);
        librarian.addBook(book10, library);

        // Display the initial books menu
        library.displayBooksMenu();

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Ask the user to login
        boolean isAuthenticated = false;
        while (!isAuthenticated) {
            System.out.println("Please log in to continue.");
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // Check if the user is a librarian or member
            Member loggedInUser;
            Librarian loggedInloggedInUser;

            if (member.login(email, password)) {
                System.out.println("Login successful! Welcome, Member " + member.getEmail() + ".");
                isAuthenticated = true;
                loggedInUser = member;

            } else if (librarian.login(email, password)) {
                System.out.println("Login successful! Welcome, Librarian " + librarian.getName() + ".");
                isAuthenticated = true;
                boolean isLibrarian = true; // Mark as librarian
                loggedInloggedInUser = librarian;
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }


            boolean running = true;
            // Main loop for user interaction
            while (running) {
                System.out.println("\n--- Library Management System ---");
                System.out.println("1. Borrow a book");
                System.out.println("2. Return a book");
                System.out.println("3. Check book availability");
                System.out.println("4. Display all books");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int option = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character

                switch (option) {
                    case 1: // Borrow a book
                        System.out.print("Enter the name of the book you want to borrow: ");
                        String bookToBorrow = scanner.nextLine();
                        Book bookBorrow = library.findBookByName(bookToBorrow);
                        if (bookBorrow != null) {
                            member.borrowBook(bookBorrow, library);
                        } else {
                            System.out.println("The book \"" + bookToBorrow + "\" is not in the library.");
                        }
                        break;

                    case 2: // Return a book
                        System.out.print("Enter the name of the book you want to return: ");
                        String bookToReturn = scanner.nextLine();
                        Book bookReturn = library.findBookByName(bookToReturn);
                        if (bookReturn != null) {
                            member.returnBook(bookReturn, library);
                        } else {
                            System.out.println("The book \"" + bookToReturn + "\" is not in the library.");
                        }
                        break;

                    case 3: // Check book availability
                        System.out.print("Enter the name of the book to check availability: ");
                        String bookToCheck = scanner.nextLine();
                        Book bookCheck = library.findBookByName(bookToCheck);
                        if (bookCheck != null) {
                            System.out.println("Is the book \"" + bookToCheck + "\" available? " + library.isBookAvailable(bookCheck));
                        } else {
                            System.out.println("The book \"" + bookToCheck + "\" is not in the library.");
                        }
                        break;

                    case 4: // Display all books
                        library.displayBooksMenu();
                        break;

                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting the system. Thank you!");
                        break;

                    default:
                        System.out.println("Invalid option! Please choose a valid option.");
                        break;
                }
            }

            // Close the scanner
            scanner.close();
        }
    }
}
