package practical_work_01.tests.task_05;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import practical_work_01.tasks.task_05.ArrayUnnecessaryMain;


class ArrayUnnecessaryMainTest {

    int[] arrInput = new int[]{2, 3, 1, 4, 5, 2, 8, 9, 10};
    int expectedRes = 2;
    ArrayUnnecessaryMain arrayUnnecessaryMain = new ArrayUnnecessaryMain();

    @Test
    void main() {
        Assert.assertEquals(expectedRes, arrayUnnecessaryMain.unnecessaryNumbersCount(arrInput), 0.1);
    }
}