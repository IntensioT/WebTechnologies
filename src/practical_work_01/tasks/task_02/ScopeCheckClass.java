package practical_work_01.tasks.task_02;

public class ScopeCheckClass {
    public static void main(String[] args) {
        float inputX = 2;
        float inputY = 3;
        System.out.println("Your result is " + checkBelonging(inputX, inputY));
    }

    public static boolean checkBelonging(float x, float y) {
        boolean result = false;
        if (y > 0 && y <= 5) {
            if (x <= 4 && x >= -4) result = true;
        } else if (y >= -5) {
            if (x <= 6 && x >= -6) result = true;
        }
        return result;
    }
}
