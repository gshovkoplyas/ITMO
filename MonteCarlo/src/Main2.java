import java.util.ArrayList;
import java.util.Random;

/**
 * Created by GSHARK on 24.06.2016.
 * Variant 22
 */
public class Main2 {
    static final int N1 = 10_000;
    static final int N2 = 1_000_000;

    public static void main(String[] args) {
        new Main2().calculate(N1);
        new Main2().calculate(N2);
    }

    final double t = 1.96; //gamma = 0.95
    final double wolframVolume = 26;
    final double lambda = 0.5;
    final Random rnd = new Random(22);

    //Случайная точка из [0; +inf] при распределении exp(-lambda * x)
    double rand(double lambda) {
        return -1 / lambda * Math.log(1 - rnd.nextDouble());
    }

    // f(x) = (x+1)^2 * exp(-x/2)
    // exp(-x/2) = f_x,
    // lambda = 1/2
    double f(double x) {
        return Math.pow(x + 1, 2); //f(x) / f_x
    }

    private void calculate(int n) {
        //Монте-Карло
        ArrayList<Double> points = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            double x = rand(lambda);
            double y = f(x);
            points.add(x);
            sum += y;
        }
        //Вычисления
        double volume = sum / n / lambda;
        double sumSquares = 0;
        for (double x : points) {
            sumSquares += Math.pow((volume - f(x)), 2);
        }
        double dispersion = Math.sqrt(sumSquares / (n - 1));
        double error = t * dispersion / Math.sqrt(n) / lambda;
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
    Значение интеграла: 26,02430612
    Значение интеграла с wolframalpha: 26,00000000
    Дисперсия: 25,59447905
    Погрешность: 1,00330358
    Доверительный итервал: [25,02100254, 27,02760970]
    Объем выборки n: 1000000
    Значение интеграла: 26,00433540
    Значение интеграла с wolframalpha: 26,00000000
    Дисперсия: 25,20054829
    Погрешность: 0,09878615
    Доверительный итервал: [25,90554925, 26,10312155]
    */
}
