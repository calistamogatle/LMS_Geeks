public class Member  extends User{

        public Member(String name, String email, String password) {
            super(name, email, password );
        }

        public void borrowBook(Book book) {
            book.borrow();
        }

        public void returnBook(Book book) {
            book.returnItem();
        }

    }

