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
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 10.99, "Fiction"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 12.99, "Fiction"));
        books.add(new Book("1984", "George Orwell", 1949, 9.99, "Fiction"));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813, 7.99, "Fiction"));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 11.99, "Fiction"));
        books.add(new Book("Animal Farm", "George Orwell", 1945, 8.99, "Fiction"));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 9.99, "Fantasy"));
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 15.99, "Fantasy"));
        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997, 14.99, "Fantasy"));
        books.add(new Book("The Da Vinci Code", "Dan Brown", 2003, 11.99, "Mystery"));
        books.add(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", 2005, 13.99, "Mystery"));
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012, 10.99, "Mystery"));
        books.add(new Book("The Hunger Games", "Suzanne Collins", 2008, 12.99, "Young Adult"));
        books.add(new Book("Divergent", "Veronica Roth", 2011, 11.99, "Young Adult"));
        books.add(new Book("The Fault in Our Stars", "John Green", 2012, 10.99, "Young Adult"));
        books.add(new Book("The Alchemist", "Paulo Coelho", 1988, 9.99, "Fiction"));
        books.add(new Book("The Kite Runner", "Khaled Hosseini", 2003, 10.99, "Fiction"));
        books.add(new Book("The Road", "Cormac McCarthy", 2006, 11.99, "Fiction"));
        books.add(new Book("Life of Pi", "Yann Martel", 2001, 12.99, "Fiction"));
        books.add(new Book("The Book Thief", "Markus Zusak", 2005, 9.99, "Fiction"));



        Library library = new Library(books);

        System.out.println("Author with most books: " + library.authorWithMostBooks());
        System.out.println("Most popular genre: " + library.mostPopularGenre());
        System.out.println("Year with most published books: " + library.yearWithMostPublishedBooks());
    }
}
