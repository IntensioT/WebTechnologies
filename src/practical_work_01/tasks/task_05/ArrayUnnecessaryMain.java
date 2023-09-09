package practical_work_01.tasks.task_05;

public class ArrayUnnecessaryMain {
    public static void main(String[]args){
        int[] arr = new int[] {2,3,1,4,5,2,8,9,10};
        System.out.println(unnecessaryNumbersCount(arr));
    }
    public static int unnecessaryNumbersCount(int[] initialArray)  {
        if(initialArray == null){
            return 0;
        }
        if(initialArray.length == 0){
            return 0;
        }

        if (initialArray.length == 1){
            return 0;
        }

        return countNumbers(initialArray);
    }

    private static int countNumbers(int[] numbers){
        int resultCount = 0, currMaxNumber = numbers[0];
        for(int i = 0; i < numbers.length - 1; i++){
            if (numbers[i + 1] <= currMaxNumber){
                resultCount++;
            }
            else{
                currMaxNumber = numbers[i + 1];
            }
        }

        return resultCount;
    }

}
