package practical_work_01.tasks.task_01;

public class CalculationClass {
    double result = 0;

    double numerator(double x, double y) {
        return (1 + (Math.sin(x + y) * Math.sin(x + y)));
    }

    double denumerator(double x, double y) {
        return (2 + Math.abs(x - (2 * x / (1 + x * x * y * y))));
    }

    public double calculate(double x, double y) {
        return ((numerator(x, y) / denumerator(x, y)) + x);
    }

    public CalculationClass(double x, double y) {
        result = calculate(x, y);
    }
}
