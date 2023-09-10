package practical_work_01.tasks.task_12;

public class Book implements Cloneable, Comparable<Book> {
    private String title;
    private String author;
    private int price;
    private static int edition;
    private int isbn;

    // setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // setter for price
    public void setPrice(int price) {
        this.price = price;
    }

    // setter for isbn
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Book(String author, int isbn) {
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {

        return 10 * title.hashCode() + 31 * author.hashCode() + 20456;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Book)) return false;

        Book book = (Book) obj;
        return this.title.equals(book.title) && this.author.equals(book.author) && this.price == book.price;
    }

    @Override
    public String toString() {

        return "Title:" + title + "|Author:" + author + "|Price:" + price + "|Edition:" + edition + "|isbn:" + isbn;
    }

    @Override
    public int compareTo(Book o) {
        return this.isbn - o.isbn;
    }

    @Override
    public Book clone() {
        try {
            // call the clone() method of Object class
            Book copy = (Book) super.clone();
            // modify the fields of copy if needed
            // for example, if you have mutable fields like arrays or collections
            // you need to create deep copies of them
            return copy;
        } catch (CloneNotSupportedException e) {
            // this should not happen
            throw new RuntimeException(e);
        }
    }
}