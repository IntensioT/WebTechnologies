package practical_work_01.tasks.task_08;

import java.util.Arrays;

public class FindIndexesOfArrayMain {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] array2 = new int[]{0, 4, 6, 8, 9, 10};
        System.out.println((Arrays.toString(findIndexes(array1, array2))));
    }

    public static int[] findIndexes(int[] array1, int[] array2) {
        int[] indexesForSecond = new int[array2.length];

        int countOfChecked = 0;
        for (int i = 0; i < array1.length; i++) {
            while (array1[i] >= array2[countOfChecked]) {
                indexesForSecond[countOfChecked] = i + countOfChecked;
                countOfChecked++;
            }
        }
        while (countOfChecked != array2.length) {
            indexesForSecond[countOfChecked] = array1.length + countOfChecked;
            countOfChecked++;
        }


        return indexesForSecond;
    }


}
