package Tools;

import Utils.Substitutor;
import Utils.Pair;
import Utils.Header;
import Utils.Proof;
import Utils.Tree.*;
import Utils.Tree.Expression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static Utils.Simplificator.simplify;

public class Prover {
    private final HashSet<String> set = new HashSet<>();
    private final HashMap<String, Boolean> values = new HashMap<>();
    private String[] variables;
    private Expression expressionTree;
    private static final HashMap<String, ArrayList<String>> proofs = new HashMap<>();

    public Prover() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("proofs.txt")));
            ArrayList<String> lines = new ArrayList<>();
            String cur = in.readLine();
            while (cur != null) {
                lines.add(cur);
                cur = in.readLine();
            }
            for (int i = 0; i < lines.size(); i++) {
                String name = lines.get(i++);
                proofs.put(name, new ArrayList<>());
                while (i < lines.size()) {
                    if (lines.get(i).equals("---")) {
                        break;
                    }
                    proofs.get(name).add(lines.get(i++));
                }
                Proof proof = new Proof();
                if (name.contains("|-")) {
                    proof.header = new Header(name);
                }
                proof.list = proofs.get(name);
                if (!new Checker().check(proof).ok) throw new AssertionError();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void calcVars(Expression exp) {
        for (int i = 0; i < exp.children.length; i++) {
            calcVars(exp.children[i]);
        }
        if (exp.type().equals("Variable")) {
            set.add(exp.toString());
        }
    }

    private boolean execute(Expression exp) {
        if (exp.type().equals("Variable")) {
            return values.get(exp.toString());
        }
        boolean a[] = new boolean[exp.children.length];
        for (int i = 0; i < exp.children.length; i++) {
            a[i] = execute(exp.children[i]);
        }
        return exp.execute(a);
    }

    private Pair<ArrayList<String>, Boolean> makeStructuralProof(Expression exp) {
        if (exp.type().equals("Variable")) {
            ArrayList<String> a = new ArrayList<>();
            a.add((values.get(exp.toString()) ? "" : "!") + exp.toString());
            return new Pair<>(a, values.get(exp.toString()));
        }
        boolean v[] = new boolean[exp.children.length];
        ArrayList<String> res = new ArrayList<>();
        String g[] = new String[exp.children.length];
        for (int i = 0; i < exp.children.length; i++) {
            Pair<ArrayList<String>, Boolean> p = makeStructuralProof(exp.children[i]);
            v[i] = p.getSecond();
            res.addAll(p.getFirst());
            g[i] = exp.children[i].toString();
        }
        boolean value = exp.execute(v);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.children.length; i++) {
            if (!v[i]) {
                sb.append("!");
            }
            sb.append((char) ('A' + i));
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("|-");
        if (!value) {
            sb.append("!(");
        }
        if (exp instanceof BinaryExpression) {
            sb.append("A");
            sb.append(exp.type());
            sb.append("B");
        } else if (exp instanceof Not) {
            sb.append("!A");
        }
        if (!value) {
            sb.append(")");
        }
        res.addAll(getProof(sb.toString(), g));
        return new Pair<>(res, value);
    }

    public static Proof assumptionRemoval(Proof proof1, Proof proof2) {
        Proof proof3 = proof1;
        proof1 = proof2;
        proof2 = proof3;
        Proof res = new Proof();
        String p = Expression.getTree(proof1.list.get(proof1.list.size() - 1)).children[0].toString();
        String a = Expression.getTree(proof1.list.get(proof1.list.size() - 1)).children[1].toString();
        res.header = new Header(proof1.header);
        res.header.expression = Expression.getTree(res.header.expression).children[1].toString();
        res.list.addAll(proof1.list);
        res.list.addAll(proof2.list);
        res.list.addAll(getProof("A|!A", (new Variable(p)).toString()));
        res.list.add(Substitutor.substitute("(A->B)->(!A->B)->(A|!A)->B", p, a));
        res.list.add(Substitutor.substitute("(!A->B)->(A|!A)->B", p, a));
        res.list.add(Substitutor.substitute("(A|!A)->B", p, a));
        res.list.add(Substitutor.substitute("B", p, a));

        return simplify(res);
    }

    private Proof getProof(int cur) {
        if (cur == variables.length) {
            Proof res = new Proof();
            res.header = new Header();
            res.header.expression = expressionTree.toString();
            for (String variable : variables) {
                res.header.assumptions.add((values.get(variable) ? "" : "!") + variable);
            }
            res.list = makeStructuralProof(expressionTree).getFirst();
            return simplify(res);
        }
        values.put(variables[cur], false);
        Proof proof1 = getProof(cur + 1);
        values.put(variables[cur], true);
        Proof proof2 = getProof(cur + 1);

        proof1 = new Deductor().deduce(proof1);
        proof2 = new Deductor().deduce(proof2);

        return assumptionRemoval(proof1, proof2);
    }

    static public ArrayList<String> getProof(String theorem, String... formulas) {
        ArrayList<String> res = new ArrayList<>();
        if (!proofs.containsKey(theorem)) {
            throw new AssertionError();
        }
        for (String s : proofs.get(theorem)) {
            String cur = Substitutor.substitute(s, formulas);
            res.add(cur);
        }
        return res;
    }

    private static final String BOOL[] = new String[]{"Л", "И"};

    public Proof prove(String expr) {
        expressionTree = Expression.getTree(expr);
        calcVars(expressionTree);
        variables = new String[set.size()];
        variables = set.toArray(variables);
        for (int mask = 0; mask < (1 << variables.length); mask++) {
            for (int i = 0; i < variables.length; i++) {
                values.put(variables[i], (mask & (1 << i)) != 0);
            }
            if (!execute(expressionTree)) {
                StringBuilder res = new StringBuilder();
                res.append("Высказывание ложно при ");
                for (int i = 0; i < variables.length; i++) {
                    res.append(variables[i]);
                    res.append("=");
                    res.append(BOOL[(mask >> i) & 1]);
                    res.append(",");
                }
                res.deleteCharAt(res.length() - 1);
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(res.toString());
                return new Proof(tmp);
            }
        }

        return getProof(0);
    }

}
