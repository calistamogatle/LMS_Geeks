public class Member  extends User{


        private Book book;
        private boolean borrowing;

        public Member(String name, Book book, boolean borrowing) {
            super(name);
            this.book = book;
            this.borrowing = borrowing;
        }


        public void run() {
            try {
                if (borrowing) {
                    borrowBook(book); // Borrow the book
                } else {
                    returnBook(book); // Return the book
                }
            } catch (LibraryException e) {
                System.out.println(e.getMessage());
            }
        }

        // Borrow a book
        public void borrowBook(Book book) throws LibraryException {
            book.borrow();
        }

        // Return a book
        public void returnBook(Book book) throws LibraryException {
            book.returnBook();
        }
    }


//// Borrow a book
//    public void borrowBook(Book book) throws LibraryException {
//        book.borrow();
//    }
//
//    // Return a book
//    public void returnBook(Book book) throws LibraryException {
//        book.returnBook();
//    }