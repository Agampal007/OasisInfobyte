import java.util.*;

// Book class to represent each book
class Book {
    private String title;
    private String author;
    private int ISBN;
    private boolean available;

    public Book(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = true; // Initially all books are available
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

// Library class to manage books
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Search for a book by title
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Display all books in the library
    public void displayBooks() {
        System.out.println("Library Catalog:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", ISBN: " + book.getISBN() + ", Available: " + (book.isAvailable() ? "Yes" : "No"));
        }
    }
}

// Main class
public class DigitalLibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding some sample books
        library.addBook(new Book("Java Programming", "John Smith", 123456));
        library.addBook(new Book("Python for Beginners", "Alice Johnson", 789012));
        library.addBook(new Book("Data Structures and Algorithms", "Emily Davis", 345678));

        // Sample usage for users
        library.displayBooks();
        Book searchedBook = library.searchBook("Java Programming");
        if (searchedBook != null) {
            System.out.println("Book found: " + searchedBook.getTitle());
            // Logic for issuing/returning books
        } else {
            System.out.println("Book not found!");
        }

        // Sample usage for admin
        // Admin can perform operations like adding, updating, deleting books
        // Admin can also generate reports, manage users, etc.
    }
}
