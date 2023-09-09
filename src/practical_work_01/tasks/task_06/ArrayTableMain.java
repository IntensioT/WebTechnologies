package practical_work_01.tasks.task_06;

public class ArrayTableMain {
    public static void main(String[] args){
        int[] inputArray = new int[] {1,2,3,4,5,6,7,8,9,10};
        tableShow(tableCreate(inputArray));
    }

    private static void tableShow(int[][] table){
        for (int[] array: table) {
            for (int element: array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[][] tableCreate(int[] inputArray){
        int n = inputArray.length;
        int[][] table = new int[n][n];

        int i = 0;

        for (int arrayI = 0; arrayI < n; arrayI++) {
            for (int arrayJ = 0; arrayJ<n;arrayJ++) {
                table[arrayI][arrayJ] = inputArray[i++ % n];
            }
            i++;
        }

        return table;
    }
}
