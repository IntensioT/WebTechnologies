package practical_work_01.tasks.task_15.comparator;

import practical_work_01.tasks.task_15.Book;

import java.util.Comparator;

public class PriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
