package ru.ifmo.ctddev.shovkoplias.parsers.lab4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class Test {

    public static void main(String[] args) throws Exception {
        //InputStream is = new ByteArrayInputStream("a+".getBytes());
        InputStream is = new ByteArrayInputStream("232^^".getBytes());

        MathParser parser = new MathParser();
        int res = parser.parse(is);
        System.out.println(res);

        /*RegexpParser parser = new RegexpParser();
        Tree tree = parser.parse(is, "Test grammar");
        DSutils.show(tree, 30, 15);*/

        is.close();
    }
}
