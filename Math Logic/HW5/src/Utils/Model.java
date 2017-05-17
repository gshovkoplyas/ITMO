package Utils;

import Utils.Tree.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class Model {
    public ArrayList<Model> children;
    public World world;
    private boolean active;
    private int size;
    private Model parent;
    private HashMap<Expression, Boolean> was = new HashMap<>();

    private Model(World world, Model parent) {
        this(world);
        this.parent = parent;
    }

    public int size() {
        return size;
    }

    public Model(World world) {
        children = new ArrayList<>();
        this.world = world;
        active = true;
        size = 0;
    }

    public void generate(Set<World> worlds, int sizeLimit, ArrayList<Model> all) {
        for (World world : worlds) {
            if (this.world.isSubsetOf(world)
                    && world.size() <= sizeLimit
                    && (world.size() == (this.world.size() + 1))
                    || this.world.equals(world)
                    && world.size() < sizeLimit - 1) {
                add(world);
                Model next = children.get(children.size() - 1);
                all.add(next);
                if (!this.world.equals(world)) {
                    next.generate(worlds, sizeLimit, all);
                } else {
                    next.generate(worlds, sizeLimit - 1, all);
                }
                size += next.size + 1;
            }
        }
    }

    void add(World world) {
        children.add(new Model(world, this));
    }

    private String toString(int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shift; ++i) {
            sb.append(" ");
        }
        sb.append("|-");
        for (Expression variable : world.getVariables()) {
            sb.append(variable.toString()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");
        for (Model child : children) {
            if (child.isActive()) {
                sb.append(child.toString(shift + 1));
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public boolean check(Expression expr) {
        if (!isActive()) {
            return true;
        }
        if (!was.containsKey(expr)) {
            was.put(expr, expr.check(this));
        }
        return was.get(expr);
    }

    public boolean isActive() {
        return active;
    }

    public void update() {
        was.clear();
        if (parent != null) {
            parent.update();
        }
    }

    public void setActive(boolean active) {
        if (active != this.active) {
            update();
        }
        this.active = active;
    }

}
