package Utils;


import Tools.Checker;

import java.util.ArrayList;
import java.util.HashSet;

import static Utils.CheckerOutput.getAnnotation;
import static Utils.CheckerOutput.getExpression;


public class Simplificator {
    public static Proof simplify(Proof proof) {
        if (proof.header != null) {
            while (!proof.list.isEmpty() && !proof.list.get(proof.list.size() - 1).equals(proof.header.expression)) {
                proof.list.remove(proof.list.size() - 1);
            }
            if (proof.list.isEmpty()) {
                throw new AssertionError("Not proved");
            }
        }
        CheckerOutput output = new Checker().check(proof);
        boolean need[] = new boolean[output.list.size()];
        need[need.length - 1] = true;
        for (int i = output.list.size() - 1; i >= 0; i--) {
            String an = getAnnotation(output.list.get(i));
            if (need[i] && an.startsWith("M.P.")) {
                int first = Integer.parseInt(an.substring(5, an.indexOf(',')));
                int second = Integer.parseInt(an.substring(an.indexOf(',') + 2));
                need[first - 1] = true;
                need[second - 1] = true;
            }
        }
        ArrayList<String> res = new ArrayList<>();
        HashSet<String> was = new HashSet<>();
        for (int i = 0; i < output.list.size() - 1; i++) {
            String cur = getExpression(output.list.get(i));
            if (need[i] && !was.contains(cur)) {
                res.add(cur);
                was.add(cur);
            }
        }
        res.add(getExpression(output.list.get(output.list.size() - 1)));
        Proof ans = new Proof();
        ans.header = proof.header;
        ans.list = res;
        return ans;
    }
}
