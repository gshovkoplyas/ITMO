package ru.ifmo.ctddev.shovkoplias.parsers.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class VariableChanger {
    private static HashMap<String, String> names = new HashMap<>();
    private static ArrayList<String> news = new ArrayList<>();
    private static ArrayList<String> alls = new ArrayList<>();
    private static int cnt = 0;

    private static String gen() {
        int pattern = cnt + 256;
        String res = "";
        if (pattern % 2 == 0)
            res += "O";
        else
            res += "l";
        pattern /= 2;
        while (pattern > 0) {
            switch (pattern % 4) {
                case 0:
                    res += "O";
                    break;
                case 1:
                    res += "0";
                    break;
                case 2:
                    res += "l";
                    break;
                case 3:
                    res += "1";
                    break;
            }
            pattern /= 4;
        }
        return res;
    }

    public static void add(String name) {
        if (!names.containsKey(name)) {
            String newName = gen();
            cnt++;
            names.put(name, newName);
            alls.add(change(name));
        }
    }

    public static void addNew(String name) {
        add(name);
        news.add(change(name));
        System.err.println(name + " " + change(name));
    }

    static Random rnd1 = new Random(328);

    public static String trash() {
        if (news.size() == 0 || alls.size() == 0) {
            return "";
        }
        int i = rnd1.nextInt(news.size());
        int j = rnd1.nextInt(alls.size());
        System.err.println(news.size() + " " + alls.size() + " " + i + " " + j);
        System.err.println(news.get(i) + " := " + alls.get(j) + ";");
        return news.get(i) + " := " + alls.get(j) + ";";
    }

    public static String change(String name) {
        if (!names.containsKey(name)) {
            return name;
        } else {
            return names.get(name);
        }
    }

    public static void clean() {
        names = new HashMap<>();
        news = new ArrayList<>();
        alls = new ArrayList<>();
    }
}
