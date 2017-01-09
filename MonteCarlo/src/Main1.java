import java.util.Random;

/**
 * Created by GSHARK on 24.06.2016.
 * Variant 22
 */
public class Main1 {
    static final int N1 = 10_000;
    static final int N2 = 1_000_000;

    public static void main(String[] args) {
        new Main1().calculate(N1);
        new Main1().calculate(N2);
    }

    final double a = 11;
    final int k = 4;
    final double c = 0.2;
    final double t = 1.96; //gamma = 0.95

    final Random rnd = new Random(22);

    double rand(double from, double to) {
        return from + rnd.nextDouble() * (to - from);
    }

    double f(double x) {
        return Math.pow(x, a);
    }

    private void calculate(int n) {
        //Монте-Карло
        double inside = 0;
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < k; j++) {
                double x = rand(0, 1);
                double y = f(x);
                sum += y;
            }
            if (sum <= c) inside++;
        }
        //Вычисления
        double volume = inside / n;
        double dispersion = Math.sqrt((inside * (1 - volume)) / (n - 1));
        double error = t * dispersion / Math.sqrt(n);
        double from = volume - error;
        double to = volume + error;
        //Вывод
        System.out.println(String.format("Объем выборки n: %d", n));
        System.out.println(String.format("Объем части тела: %.8f", volume));
        System.out.println(String.format("Дисперсия: %.8f", dispersion));
        System.out.println(String.format("Погрешность: %.8f", error));
        System.out.println(String.format("Доверительный итервал: [%.8f, %.8f]", from, to));
    }
    /* Вот что программа выводит:
    Объем выборки n: 10000
    Объем части тела: 0,51770000
    Дисперсия: 0,49971160
    Погрешность: 0,00979435
    Доверительный итервал: [0,50790565, 0,52749435]
    Объем выборки n: 1000000
    Объем части тела: 0,52090000
    Дисперсия: 0,49956325
    Погрешность: 0,00097914
    Доверительный итервал: [0,51992086, 0,52187914]
    */
}
