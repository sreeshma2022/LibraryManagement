package model;

public class Book {

    private String id;
    private String title;
    private String author;
    private String genre;
    private AvailabilityStatus availability;

    public Book(String id, String title, String author, String genre, AvailabilityStatus availability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

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

    public String getGenre() {
        return genre;
    }

    public AvailabilityStatus getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityStatus availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title +", Author: " + author +", Genre: " + genre +", availability: " + availability ;

    }
}
