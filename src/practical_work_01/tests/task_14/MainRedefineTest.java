package practical_work_01.tests.task_14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practical_work_01.tasks.task_12.Book;
import practical_work_01.tasks.task_14.MainRedefine;


class MainRedefineTest {

    MainRedefine mainRedefine = new MainRedefine();
    Book clonedBook = mainRedefine.createBook("Leo Tolstoy", "War and Peace", 1000, 123).clone();
    Book expectedBook = mainRedefine.createBook("Leo Tolstoy", "War and Peace", 1000, 123);

    @Test
    void createBook() {
        System.out.println("======TEST MainRedefineTest EXECUTED=======");

        Assertions.assertTrue(clonedBook.equals(expectedBook));
    }
}