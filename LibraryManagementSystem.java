import java.util.*;
// Main Class for User Interaction
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Add Patron");
            System.out.println("5. Remove Patron");
            System.out.println("6. Display Patrons");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Is it Fiction (Y/N)? ");
                    char isFiction = scanner.next().charAt(0);
                    scanner.nextLine();  // Consume newline

                    if (isFiction == 'Y' || isFiction == 'y') {
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        library.addBook(new FictionBook(title, author, isbn, quantity, genre));
                    } else {
                        System.out.print("Enter field: ");
                        String field = scanner.nextLine();
                        library.addBook(new NonFictionBook(title, author, isbn, quantity, field));
                    }
                    System.out.println("Book added successfully!");
                    break;

                case 2: // Remove Book
                    System.out.print("Enter ISBN to remove: ");
                    isbn = scanner.nextLine();
                    library.removeBook(isbn);
                    System.out.println("Book removed.");
                    break;

                case 3: // Display Books
                    library.displayBooks();
                    break;

                case 4: // Add Patron
                    System.out.print("Enter patron name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patron ID: ");
                    int id = scanner.nextInt();
                    library.addPatron(new Patron(name, id));
                    System.out.println("Patron added.");
                    break;

                case 5: // Remove Patron
                    System.out.print("Enter patron ID to remove: ");
                    id = scanner.nextInt();
                    library.removePatron(id);
                    System.out.println("Patron removed.");
                    break;

                case 6: // Display Patrons
                    library.displayPatrons();
                    break;

                case 7: // Borrow Book
                    System.out.print("Enter patron ID: ");
                    id = scanner.nextInt();
                    System.out.print("Enter book ISBN: ");
                    isbn = scanner.next();
                    library.borrowBook(id, isbn);
                    break;

                case 8: // Return Book
                    System.out.print("Enter patron ID: ");
                    id = scanner.nextInt();
                    System.out.print("Enter book ISBN: ");
                    isbn = scanner.next();
                    library.returnBook(id, isbn);
                    break;

                case 9: // Exit
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}