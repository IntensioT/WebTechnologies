package practical_work_01.tasks.task_04;

import java.math.BigInteger;

public class ArrayPrimeCheckMain {
    public static void main(String[] args) {
        //N = 4;
        int[] inputArray = new int[]{1111, 221312, 34312, 41233};
        printIndexOfPrimeNumbers(inputArray);
    }

    public static void printIndexOfPrimeNumbers(int[] arr) {
        boolean hasPrimeNumbers = false;
        for (int j : arr)
            if (isPrime(j)) {
                hasPrimeNumbers = true;
                System.out.println(j);
            }
        if (!hasPrimeNumbers)
            System.out.println("No prime numbers");
    }

    public static boolean isPrime(int integer) {  //Тест Рабина-Миллера встроенный в BigInteger
        BigInteger bigInteger = BigInteger.valueOf(integer);
        return bigInteger.isProbablePrime((int) Math.log(integer));
    }
}
