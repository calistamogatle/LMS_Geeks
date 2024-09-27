class Book implements Loanable {
    private String title;
    private String author;
    private String ISBN;
    private boolean available;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = true; // Book is initially available
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

    @Override
    public void returnItem() {
        available = true;
        System.out.println(title + " is returned.");
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + ISBN + ")";
    }
}
