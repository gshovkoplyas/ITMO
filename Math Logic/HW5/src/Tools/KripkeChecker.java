package Tools;

import Utils.Model;
import Utils.Tree.Expression;
import Utils.World;

import java.util.HashSet;
import java.util.ArrayList;

public class KripkeChecker {
    private Model main;
    private ArrayList<Model> all;

    public KripkeChecker() {
        this.main = new Model(new World());
        this.all = new ArrayList<>();
    }

    private HashSet<World> generateWorldsCombinations(ArrayList<Expression> variables) {
        HashSet<World> res = new HashSet<>();
        for (int mask = 0; mask < (1 << variables.size()); mask++) {
            World world = new World();
            for (int j = 0; j < variables.size(); j++) {
                if (((mask >> j) & 1) == 1) {
                    world.forceVariable(variables.get(j));
                }
            }
            res.add(world);
        }
        return res;
    }


    boolean check(Expression expr, int index) {
        Model model = all.get(index);
        if (model == all.get(all.size() - 1)) {
            model.setActive(true);
            if (!main.check(expr)) {
                return false;
            }
            model.setActive(false);
            return main.check(expr);
        }

        model.setActive(false);
        int next = index + 1;
        if (model.size() != 0) {
            next = index + 1 + model.size();
        }
        next = Math.min(all.size() - 1, next);
        if (!check(expr, next))
            return false;

        model.setActive(true);
        return check(expr, index + 1);

    }

    public Model contraModel(String expression) {
        Expression expr = Expression.getTree(expression);
        ArrayList<Expression> variables = new ArrayList<>(expr.getVariables());
        HashSet<World> worldsCombinations = generateWorldsCombinations(variables);
        main.generate(worldsCombinations, variables.size(), all);
        if (check(expr, 0)) {
            return null;
        }
        return main;
    }

}
