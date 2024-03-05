import java.util.*;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double price;
    private String genre;

    public Book(String title, String author, int publicationYear, double price, String genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
        this.genre = genre;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                '}';
    }
}

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public String authorWithMostBooks() {
        Map<String, Long> authorBookCount = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));

        return authorBookCount.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public String mostPopularGenre() {
        Map<String, Long> genreCount = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));

        return genreCount.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public int yearWithMostPublishedBooks() {
        Map<Integer, Long> yearBookCount = books.stream()
                .collect(Collectors.groupingBy(Book::getPublicationYear, Collectors.counting()));

        return yearBookCount.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(0);
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Title1", "Author1", 2000, 20.0, "Genre1"));
        books.add(new Book("Title2", "Author2", 2005, 25.0, "Genre2"));
        // Add more books here

        Library library = new Library(books);

        // Advanced queries
        System.out.println("Author with most books: " + library.authorWithMostBooks());
        System.out.println("Most popular genre: " + library.mostPopularGenre());
        System.out.println("Year with most published books: " + library.yearWithMostPublishedBooks());
    }
}
