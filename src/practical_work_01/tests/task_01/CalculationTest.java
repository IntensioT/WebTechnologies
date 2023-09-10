package practical_work_01.tests.task_01;

import org.junit.jupiter.api.Assertions;
import practical_work_01.tasks.task_01.CalculationClass;


class CalculationTest {
    double testX = 10;
    double testY = 20;
    CalculationClass calculationClass = new CalculationClass(10, 20);
    double expectedResult = 10.16469;


    @org.junit.jupiter.api.Test
    void calculate() {
        System.out.println("======TEST CALCULATION EXECUTED=======");
        Assertions.assertEquals(expectedResult, calculationClass.calculate(testX, testY), 0.01);
    }
}