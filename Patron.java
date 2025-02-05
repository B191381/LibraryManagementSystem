import java.util.*;
class Patron {
    private String name;
    private int id;
    private List<Book> borrowedBooks;

    public Patron(String name, int id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    
    public boolean borrowBook(Book book) {
        if (book.borrow()) {
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        for (Book book : borrowedBooks) {
            if (book.getISBN().equals(isbn)) {
                borrowedBooks.remove(book);
                book.returnBook();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", Borrowed: " + borrowedBooks.size() + " books)";
    }
}
