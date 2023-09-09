package practical_work_01.tasks.task_13;

import practical_work_01.tasks.task_12.Book;
import java.util.Objects;

public class ProgrammerBook extends Book
{
    private String language;
    private int level;

    public ProgrammerBook(String author, int isbn) {
        super(author, isbn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProgrammerBook that = (ProgrammerBook) o;
        return level == that.level &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), language, level);
    }

    @Override
    public String toString() {
        return "ProgrammerBook{" +
                "language='" + language + '\'' +
                ", level=" + level +
                '}';
    }
}