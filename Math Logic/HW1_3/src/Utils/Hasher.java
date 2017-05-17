package Utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Hasher {
    Hasher() {}

    private static final HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();

    public static int getHash(ArrayList<Integer> a) {
        if (map.containsKey(a)) {
            return map.get(a);
        }
        map.put(a, map.size());
        return map.get(a);
    }
}
