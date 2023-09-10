package practical_work_01.tests.task_07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practical_work_01.tasks.task_07.ArraySortMain;

import java.util.Arrays;


class ArraySortMainTest {


    int[] arrayInput = {1, 16, 9, 12};
    int[] arrayExpected = {1, 9, 12, 16};

    @Test
    void sort() {
        System.out.println("======TEST SORT EXECUTED=======");

        //Assertions.assertEquals(arrayExpected,arraySortMain.sort(arrayInput));
        ArraySortMain.sort(arrayInput);


        Assertions.assertTrue(Arrays.equals(arrayInput, arrayExpected));
    }
}