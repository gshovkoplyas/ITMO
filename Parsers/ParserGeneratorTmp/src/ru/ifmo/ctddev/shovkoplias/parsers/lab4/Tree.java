package ru.ifmo.ctddev.shovkoplias.parsers.lab4;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.StructureGraphic.v1.DSTreeNode;

public class Tree implements DSTreeNode {

    private String node;
    private List<Tree> children = Collections.emptyList();
    private int count;
    private boolean counted;
    public Tree temp;
    private Stack<Tree> temp2 = new Stack<>();

    public Tree(String node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public void setTemp(Tree temp) {
        this.temp = temp;
    }

    public int count() {
        if (!counted) {
            count += children.size();
            for (Tree tree : children) {
                count += tree.count();
            }
            counted = true;
        }
        return count;
    }

    public Tree(String node) {
        this.node = node;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public String getNode() {
        return node;
    }

    @Override
    public String toString() {
        if (children == null) {
            return "" + node + "";
        }
        return node + ":" + Arrays.toString(children.toArray()) + "";
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
