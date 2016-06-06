package ru.ifmo.ctddev.shovkoplias.parsers.lab4;

import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        Generator generator = new Generator(true);
        try {
            generator.read(new File("src/resources/Math"), "math");
            generator.generateFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}