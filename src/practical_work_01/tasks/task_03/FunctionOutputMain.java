package practical_work_01.tasks.task_03;

public class FunctionOutputMain {
    public static void main(String[] args) {
        double a = 0;
        double b = 100;
        double h = 2;

        for (double i = a; i <= b; i += h) {
            System.out.format("| %07.3f | %07.3f |\n", i, functionCalculate(i));
        }
    }

    public static double functionCalculate(double x) {
        return Math.tan(x);
    }
}
