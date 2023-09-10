package practical_work_01.tests.task_15;


import org.junit.jupiter.api.Assertions;
import practical_work_01.tasks.task_15.Book;

import java.util.Arrays;


class MainTest {

    public static void main(String[] args) {
        // create an array of books
        Book[] books = new Book[5];
        // fill the array with some books
        books[0] = new Book("War and Peace", "Leo Tolstoy", 1000);
        books[1] = new Book("Crime and Punishment", "Fyodor Dostoyevsky", 800);
        books[2] = new Book("The Catcher in the Rye", "J.D. Salinger", 500);
        books[3] = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1200);
        books[4] = new Book("Nineteen Eighty-Four", "George Orwell", 600);


        // sort the array using the default order (by title)
        Arrays.sort(books);

        Book startedBook = books[4];


        Book expectedBook = new Book("War and Peace", "Leo Tolstoy", 1000);

        Assertions.assertTrue(startedBook.equals(expectedBook));
    }

}