package hexlet.code.model;

import java.util.List;

public final class Node {
    private String type;
    private String name;
    private Object valueBefore;
    private Object valueAfter;
    private List<Node> children;

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

    // Accessor methods
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Object getValueBefore() {
        return valueBefore;
    }

    public Object getValueAfter() {
        return valueAfter;
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return String.format("{name='%s', type='%s', valueBefore=%s, valueAfter=%s, children=%s}",
                name, type, valueBefore, valueAfter, children);
    }
}
