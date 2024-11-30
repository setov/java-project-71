package hexlet.code.model;

import java.util.List;

public class Node {
    public  String type;
    public  String name;
    public  Object valueBefore;
    public  Object valueAfter;
    public  List<Node> children;

    public Node(String type, String name, Object valueBefore, Object valueAfter, List<Node> children) {
        this.type = type;
        this.name = name;
        this.valueBefore = valueBefore;
        this.valueAfter = valueAfter;
        this.children = children;
    }

    public static Node makeNode(String type, String name, Object valueBefore, Object valueAfter, List<Node> children) {
        return new Node(type, name, valueBefore, valueAfter, children);
    }

    @Override
    public String toString() {
        return String.format("{name='%s', type='%s', valueBefore=%s, valueAfter=%s, children=%s}",
                name, type, valueBefore, valueAfter, children);
    }
}
