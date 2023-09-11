package practical_work_01.tasks.task_15;


public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int price;
    private static int edition;

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
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

        return "Title:" + title + "|Author:" + author + "|Price:" + price + "|Edition:" + edition;
    }

    @Override
    public int compareTo(Book o) {
        // compare the titles of this book and the other book
        return this.title.compareTo(o.title);
    }
}
