package ru.ifmo.ctddev.shovkoplias.google_hash;

/**
 * Created by GShark on 10.09.2016.
 */
public class Main {
    public static void main(String args[]) {
        KeyValueStorage<String, String> kvs = new KeyValueStorage<String,String>();
        kvs.put("Masha", "Moroz");
        kvs.put("Software", "Design");
        System.out.println(kvs.get("Software"));
        kvs.put("Masha", "New");
        System.out.println(kvs.get("Software"));
        System.out.println(kvs.get("Masha"));
    }
}
