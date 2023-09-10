package practical_work_01.tests.task_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practical_work_01.tasks.task_06.ArrayTableMain;


class ArrayTableMainTest {


    int expectedInt22 = 5;
    int[] inputArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    void tableCreate() {
        System.out.println("======TEST tableCreate EXECUTED=======");
        int[][] res = ArrayTableMain.tableCreate(inputArray);
        Assertions.assertEquals(expectedInt22, res[2][2], 0.01);
    }
}