class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagement {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // Book not found
    }

    public static void main(String[] args) {
        // Setup book list (unsorted for linear search)
        Book[] books = {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "The Catcher in the Rye", "J.D. Salinger")
        };

        // Linear Search
        System.out.println("Linear Search Results:");
        String searchTitle = "1984";
        Book result = linearSearch(books, searchTitle);
        System.out.println(result != null ? result : "Book not found");

        // For binary search, first sort the books array by title using a simple sorting algorithm
        sortBooksByTitle(books);

        // Binary Search
        System.out.println("\nBinary Search Results:");
        searchTitle = "1984";
        result = binarySearch(books, searchTitle);
        System.out.println(result != null ? result : "Book not found");
    }

    // Simple Bubble Sort to sort books by title
    public static void sortBooksByTitle(Book[] books) {
        int n = books.length;
        Book temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (books[j].getTitle().compareToIgnoreCase(books[j + 1].getTitle()) > 0) {
                    // Swap books[j] and books[j + 1]
                    temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }
}