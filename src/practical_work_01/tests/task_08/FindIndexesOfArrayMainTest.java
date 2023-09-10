package practical_work_01.tests.task_08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practical_work_01.tasks.task_08.FindIndexesOfArrayMain;

import java.util.Arrays;


class FindIndexesOfArrayMainTest {

    FindIndexesOfArrayMain findIndexesOfArrayMain = new FindIndexesOfArrayMain();

    int[] arrayExpected = {0, 4, 7, 9, 10, 11};
    int[] array1 = new int[]{1, 2, 3, 4, 5, 6};
    int[] array2 = new int[]{0, 4, 6, 8, 9, 10};

    @Test
    void findIndexes() {
        System.out.println("======TEST FindIndexesOfArrayMain EXECUTED=======");
        int[] res = findIndexesOfArrayMain.findIndexes(array1, array2);
        Assertions.assertTrue(Arrays.equals(res, arrayExpected));
    }
}