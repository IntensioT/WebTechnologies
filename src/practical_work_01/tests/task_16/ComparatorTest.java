package practical_work_01.tests.task_16;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import practical_work_01.tasks.task_15.Book;
import practical_work_01.tasks.task_15.ShellSort;
import practical_work_01.tasks.task_15.comparator.AuthorComparator;
import practical_work_01.tasks.task_15.comparator.TitleComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorTest {

    private ArrayList<Book> bookArrayList;
    private Comparator<Book> titleAuthorComparator;

    @Before
    public void setUp() {
        // Создаем список книг для тестирования
        bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("title4", "author3", 14));
        bookArrayList.add(new Book("title3", "author6", 9));
        bookArrayList.add(new Book("title2", "author0", 4));
        bookArrayList.add(new Book("title1", "author-1", 1));
        bookArrayList.add(new Book("title0", "author312", 4));

        // Создаем компаратор для сравнения по названию и автору
        titleAuthorComparator = new TitleComparator().thenComparing(new AuthorComparator());
    }

    @After
    public void tearDown() {
        // Освобождаем ресурсы
        bookArrayList = null;
        titleAuthorComparator = null;
    }

    @Test
    public void testTitleAuthorSort() {
        // Сортируем список книг с помощью компаратора
        ShellSort.sort(bookArrayList, titleAuthorComparator);

        // Создаем ожидаемый отсортированный список книг
        ArrayList<Book> expectedList = new ArrayList<>();
        expectedList.add(new Book("title0", "author312", 4));
        expectedList.add(new Book("title1", "author-1", 1));
        expectedList.add(new Book("title2", "author0", 4));
        expectedList.add(new Book("title3", "author6", 9));
        expectedList.add(new Book("title4", "author3", 14));

        // Проверяем, что фактический и ожидаемый списки равны
        Assert.assertEquals(expectedList, bookArrayList);
    }
}
