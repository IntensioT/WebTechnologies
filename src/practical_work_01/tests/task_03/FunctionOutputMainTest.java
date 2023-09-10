package practical_work_01.tests.task_03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practical_work_01.tasks.task_03.FunctionOutputMain;

class FunctionOutputMainTest {
    double expectedY = 0.4738154;
    double inputX = 35;

    @Test
    void functionCalculate() {
        System.out.println("======TEST FUNCTION CALCULATION EXECUTED=======");
        Assertions.assertEquals(expectedY, FunctionOutputMain.functionCalculate(inputX), 0.01);
    }
}