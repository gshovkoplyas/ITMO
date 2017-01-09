import java.util.ArrayList;
import java.util.Random;

/**
 * Created by GSHARK on 24.06.2016.
 * Variant 22
 */
public class Main3 {
    static final int N1 = 10_000;
    static final int N2 = 1_000_000;

    public static void main(String[] args) {
        new Main3().calculate(N1);
        new Main3().calculate(N2);
    }

    final double t = 1.96; //gamma = 0.95
    final double wolframVolume = 1.28002;
    final double from = 0;
    final double to = 3;
    final Random rnd = new Random(22);

    double rand(double from, double to) {
        return from + rnd.nextDouble() * (to - from);
    }

    // f(x) = sin(x) * sqrt(1+x)
    // x in [0, 3]
    double f(double x) {
        return Math.sin(x) / Math.sqrt(1 + x) * (to - from);
    }

    private void calculate(int n) {
        //Монте-Карло
        ArrayList<Double> points = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            double x = rand(from, to);
            double y = f(x);
            points.add(x);
            sum += y;
        }
        //Вычисления
        double volume = sum / n;
        double sumSquares = 0;
        for (double x : points) {
            sumSquares += Math.pow((volume - f(x)), 2);
        }
        double dispersion = Math.sqrt(sumSquares / (n - 1));
        double error = t * dispersion / Math.sqrt(n);
        double from = volume - error;
        double to = volume + error;
        //Вывод
        System.out.println(String.format("Объем выборки n: %d", n));
        System.out.println(String.format("Значение интеграла: %.8f", volume));
        System.out.println(String.format("Значение интеграла с wolframalpha: %.8f", wolframVolume));
        System.out.println(String.format("Дисперсия: %.8f", dispersion));
        System.out.println(String.format("Погрешность: %.8f", error));
        System.out.println(String.format("Доверительный итервал: [%.8f, %.8f]", from, to));
    }
    /* Вот что программа выводит:
    Объем выборки n: 10000
    Значение интеграла: 1,27913848
    Значение интеграла с wolframalpha: 1,28002000
    Дисперсия: 0,54351673
    Погрешность: 0,01065293
    Доверительный итервал: [1,26848555, 1,28979140]
    Объем выборки n: 1000000
    Значение интеграла: 1,27976729
    Значение интеграла с wolframalpha: 1,28002000
    Дисперсия: 0,54414204
    Погрешность: 0,00106652
    Доверительный итервал: [1,27870077, 1,28083381]
    */
}
