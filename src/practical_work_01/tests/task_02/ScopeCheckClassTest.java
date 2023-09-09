package practical_work_01.tests.task_02;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practical_work_01.tasks.task_02.ScopeCheckClass;

class ScopeCheckClassTest {
    float expectedXTrue = 2;
    float expectedXFalse = 20;
    float expectedYTrue = -0.11f;
    float expectedYFalse = -1111;

    ScopeCheckClass scopeCheckClass = new ScopeCheckClass();
    @Test
    void checkBelonging() {
        System.out.println("======TEST CHECK BELONGING EXECUTED=======");
        Assertions.assertTrue(ScopeCheckClass.checkBelonging(expectedXTrue, expectedYTrue));
        Assertions.assertFalse(ScopeCheckClass.checkBelonging(expectedXFalse, expectedYFalse));

    }
}