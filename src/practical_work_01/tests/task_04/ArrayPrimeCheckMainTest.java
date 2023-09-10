package practical_work_01.tests.task_04;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static practical_work_01.tasks.task_04.ArrayPrimeCheckMain.isPrime;
import static practical_work_01.tasks.task_04.ArrayPrimeCheckMain.printIndexOfPrimeNumbers;

class ArrayPrimeCheckMainTest {


    ArrayList<Integer> primeNumbers; // Список для хранения простых чисел из массива

    @Before
    public void setUp() {
        // Создаем список для хранения простых чисел из массива
        primeNumbers = new ArrayList<>();
    }

    @After
    public void tearDown() {
        // Освобождаем ресурсы
        primeNumbers = null;
    }

    @Test
    public void testPrintIndexOfPrimeNumbersWithPrimeNumbers() {
        // Создаем массив с простыми числами
        int[] inputArray = new int[]{1111, 221312, 34312, 41233};
        // Вызываем тестируемый метод
        printIndexOfPrimeNumbers(inputArray);

        // Создаем ожидаемый список простых чисел из массива
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(41233);
        // Проверяем, что фактический и ожидаемый списки равны
        Assertions.assertTrue(isPrime(41233));

    }

    @Test
    public void testPrintIndexOfPrimeNumbersWithoutPrimeNumbers() {
        // Создаем массив без простых чисел
        int[] inputArray = new int[]{1110, 221310, 34310, 41230};
        // Вызываем тестируемый метод
        printIndexOfPrimeNumbers(inputArray);
        // Создаем ожидаемый пустой список простых чисел из массива
        ArrayList<Integer> expectedList = null;
        // Проверяем, что фактический и ожидаемый списки равны
        Assertions.assertEquals(expectedList, primeNumbers);
    }

}