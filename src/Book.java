class Book implements Loanable {
    private String title;
    private String author;
    private String ISBN;
    private boolean available;

    public Book(String title) {
        this.title = title;

        this.available = true; // Book is initially available
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter for availability
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Loanable interface implementation
    @Override
    public void borrow() {
        if (available) {
            available = false;
            System.out.println(title + " is borrowed.");
        } else {
            System.out.println(title + " is currently unavailable.");
        }
    }

        // Borrow the book with exception handling
        public synchronized void borrows () throws LibraryException {
            if (!available) {
                throw new LibraryException("Book '" + title + "' is already borrowed.");
            } else {
                available = false;
                System.out.println(Thread.currentThread().getName() + " borrowed: " + title);
            }
        }
            @Override
            public void returnItem () {
                available = true;
                System.out.println(title + " is returned.");
            }
// Return the book with exception handling
            public synchronized void returnBook () throws LibraryException {
                if (available) {
                    throw new LibraryException("Book '" + title + "' hasn't been borrowed yet.");
                } else {
                    available = true;
                    System.out.println(Thread.currentThread().getName() + " returned: " + title);
                }

            }
    @Override
    public String toString () {
        return title + " by " + author + " (ISBN: " + ISBN + ")";
    }
}

