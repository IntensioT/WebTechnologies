package practical_work_01.tests.task_09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practical_work_01.tasks.task_09.Ball;
import practical_work_01.tasks.task_09.Basket;
import practical_work_01.tasks.task_09.Color;

import java.util.ArrayList;
import java.util.Arrays;


class BasketTest {

    ArrayList<Ball> balls = new ArrayList<>(Arrays.asList(
            new Ball(Color.BLUE, 0.2),
            new Ball(Color.BLACK, 0.3),
            new Ball(Color.RED, 0.1),
            new Ball(Color.BLUE, 0.2)
    ));
    Basket basket = new Basket(balls);

    @Test
    void getColorCount() {
        System.out.println("======TEST BasketTest EXECUTED=======");
        Assertions.assertEquals(2, basket.getColorCount(Color.BLUE));
    }
}