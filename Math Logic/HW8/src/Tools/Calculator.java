package Tools;

import Utils.Ordinal;

import static Utils.Ordinal.isEquals;

public class Calculator {
    public String calculate(String s) {
        String ss[] = s.split("=");
        if (isEquals(new Ordinal(ss[0]), new Ordinal(ss[1]))) {
            return "Равны";
        }
        return "Не равны";
    }
}
