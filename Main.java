package LibraryManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static Library library;
    private static Scanner scanner;

    public static void main(String[] args) {
        library = Library.loadLibraryState();
        if (library == null) {
            library = new Library();
        }
        scanner = new Scanner(System.in);
        start();
    }

    public static void start() {
        int choice = -1;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        addUser();
                        break;
                    case 3:
                        displayBooks();
                        break;
                    case 4:
                        borrowBook();
                        break;
                    case 5:
                        returnBook();
                        break;
                    case 6:
                        searchBooksByTitleOrAuthor();
                        break;
                    case 7:
                        saveLibraryState();
                        break;
                    case 8:
                        library = Library.loadLibraryState();
                        if (library == null) {
                            System.out.println("No saved library state found.");
                            library = new Library();
                        } else {
                            System.out.println("Library state loaded successfully.");
                        }
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                choice = -1; // Reset choice to trigger menu redisplay
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("===== Library Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. Add User");
        System.out.println("3. Display Books");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Search Books by Title or Author");
        System.out.println("7. Save Library State");
        System.out.println("8. Load Library State");
        System.out.println("0. Exit");
        System.out.println("=====================================");
    }

    public static void addBook() {
        System.out.println("Enter Book Details:");
        try {
            System.out.print("Book ID: ");
            int bookID = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Genre: ");
            String genre = scanner.nextLine();

            Book newBook = new Book(bookID, title, author, genre, true);
            library.addBook(newBook);
            System.out.println("Book added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
        }
    }

    public static void addUser() {
        System.out.println("Enter User Details:");
        try {
            System.out.print("User ID: ");
            int userID = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Contact Information: ");
            String contactInfo = scanner.nextLine();

            User newUser = new User(userID, name, contactInfo);
            library.addUser(newUser);
            System.out.println("User added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
        }
    }

    public static void displayBooks() {
        System.out.println("===== Available Books =====");
        for (Book book : library.getBooks()) {
            if (book.isAvailable()) {
                System.out.println(book.getBookID() + ": " + book.getTitle() + " by " + book.getAuthor());
            }
        }
        System.out.println("===========================");
    }

    public static void borrowBook() {
        System.out.println("Enter User ID:");
        int userID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter Book ID:");
        int bookID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        User user = library.findUserById(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        Book book = library.findBookById(bookID);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (library.checkOutBook(user, book)) {
            System.out.println("Book successfully borrowed.");
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    public static void returnBook() {
        System.out.println("Enter User ID:");
        int userID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter Book ID:");
        int bookID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        User user = library.findUserById(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        Book book = library.findBookById(bookID);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (library.returnBook(user, book)) {
            System.out.println("Book successfully returned.");
        } else {
            System.out.println("Book not borrowed by the user.");
        }
    }

    public static void searchBooksByTitleOrAuthor() {
        System.out.println("Enter title or author:");
        String keyword = scanner.nextLine();

        List<Book> foundBooks = library.searchByTitle(keyword);
        foundBooks.addAll(library.searchByAuthor(keyword));

        if (foundBooks.isEmpty()) {
            System.out.println("No books found with the given title or author.");
        } else {
            System.out.println("===== Found Books =====");
            for (Book book : foundBooks) {
                System.out.println(book.getBookID() + ": " + book.getTitle() + " by " + book.getAuthor());
            }
            System.out.println("=======================");
        }
    }

    public static void saveLibraryState() {
        library.saveLibraryState();
    }
}