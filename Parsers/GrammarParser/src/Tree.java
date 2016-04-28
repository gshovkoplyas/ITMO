import java.awt.*;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.StructureGraphic.v1.DSTreeNode;

/**
 * Created by shovkoplyas on 25.04.2016.
 */
public class Tree implements DSTreeNode{
    String node;

    List<Tree> children;

    public Tree(String node, Tree ... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public Tree(String node) {
        this.node = node;
    }

    public void print(PrintStream out) {
        print(out, "");
    }

    private void print(PrintStream out, String offset) {
        out.println(offset + node);
        if (children == null) {
            return;
        }
        for (Tree child: children) {
            child.print(out, offset + "|");
        }
    }

    public int maxNodeLen() {
        int res = node.length();
        if (children == null) {
            return res;
        }
        for (Tree child: children) {
            res = Math.max(child.maxNodeLen(), res);
        }
        return res;
    }

    @Override
    public DSTreeNode[] DSgetChildren() {
        if (children == null) {
            return new DSTreeNode[0];
        }
        return children.toArray(new DSTreeNode[children.size()]);
    }

    @Override
    public Object DSgetValue() {
        return node;
    }

    @Override
    public Color DSgetColor() {
        return Color.black;
    }
}
