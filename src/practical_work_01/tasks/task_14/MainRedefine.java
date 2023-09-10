package practical_work_01.tasks.task_14;

import practical_work_01.tasks.task_12.Book;


public class MainRedefine {
    public static void main(String[] args) {
        // create a book object
        Book book1 = createBook("Leo Tolstoy", "War and Peace", 1000, 123);
        // print the book
        System.out.println(book1);

        // create a copy of the book using clone()
        Book book2 = book1.clone();
        // change some fields of the copy
        book2.setIsbn(456);
        book2.setPrice(800);
        // print the copy
        System.out.println(book2);

        // create another copy of the book using clone()
        Book book3 = book1.clone();
        // change some fields of the copy
        book3.setIsbn(789);
        book3.setAuthor("Fyodor Dostoyevsky");
        // print the copy
        System.out.println(book3);
    }

    // a helper method to create a book object with given parameters
    public static Book createBook(String author, String title, int price, int isbn) {
        // create a new book object
        Book book = new Book(author, isbn);
        // set the title and price
        book.setTitle(title);
        book.setPrice(price);
        // return the book object
        return book;
    }


}