package Utils;

import Utils.Tree.Expression;

import java.util.HashSet;

public class World {
    private HashSet<Expression> variables;

    public HashSet<Expression> getVariables() {
        return variables;
    }

    public int size() {
        return variables.size();
    }

    public World() {
        variables = new HashSet<>();
    }

    boolean isSubsetOf(World world) {
        return world.size() > size() && world.getVariables().containsAll(variables);
    }

    public void forceVariable(Expression var) {
        variables.add(var);
    }

    public boolean isForced(Expression var) {
        return variables.contains(var);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        return variables != null ? variables.equals(world.variables) : world.variables == null;

    }

    @Override
    public int hashCode() {
        return variables != null ? variables.hashCode() : 0;
    }
}
