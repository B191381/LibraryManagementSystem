import java.util.*;
// Library Management System
class Library {
    //collection of book based on the ISBN number
    private Map<String, Book> books;
    //collection of patrons based on the patron id
    private Map<Integer, Patron> patrons;

    public Library() {
        books = new HashMap<>();
        patrons = new HashMap<>();
    }

    // Book Management
    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public void displayBooks() {
        /*if (books.isEmpty()) {
            throw new MyException("No books available.");
        }
        books.values().forEach(System.out::println);*/
        try {
            //using stream method reference displaying the books from map
            books.values().forEach(System.out::println);
        }
        catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    // Patron Management
    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public void removePatron(int id) {
        patrons.remove(id);
    }
    //using stream method reference displaying the patrons from map
    public void displayPatrons() {
        if (patrons.isEmpty()) {
            //if patrons not there throwing a custom exception
            throw new MyException("No patrons registered.");
        }
        patrons.values().forEach(System.out::println);
    }

    // Borrow and Return Books
    public void borrowBook(int patronId, String isbn) {
        Patron patron = patrons.get(patronId);
        Book book = books.get(isbn);

        if (patron != null && book != null && patron.borrowBook(book)) {
            System.out.println(patron.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Borrowing failed.");
        }
    }

    public void returnBook(int patronId, String isbn) {
        Patron patron = patrons.get(patronId);
        if (patron != null && patron.returnBook(isbn)) {
            System.out.println("Book returned successfully.");
        } else {
            throw new MyException("Return failed.");
        }
    }
}

//custom exception
class MyException extends RuntimeException {
    MyException(String message) {
        super(message);
    }
}
