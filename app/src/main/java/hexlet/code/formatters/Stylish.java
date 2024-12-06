package hexlet.code.formatters;

import java.util.List;
import java.util.stream.Collectors;

import hexlet.code.model.Node;

public class Stylish {
    public static String stylish(List<Node> nodes) {
        var list = nodes.stream()
                .map(Stylish::formatNodeStylish)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining("\n"));
        return "{\n" + list + "\n}";
    }

    private static String formatNodeStylish(Node node) {
        var name = node.name;
        var type = node.type;
        var valueBefore = node.valueBefore;
        var valueAfter = node.valueAfter;

        switch (type) {
            case "removed":
                return String.format("  - %s: %s", name, valueBefore);
            case "unchanged":
                return String.format("    %s: %s", name, valueBefore);
            case "updated":
                String beforeFormat = String.format("  - %s: %s", name, valueBefore);
                String afterFormat = String.format("  + %s: %s", name, valueAfter);
                return String.join("\n", beforeFormat, afterFormat);
            case "added":
                return String.format("  + %s: %s", name, valueAfter);
            default:
                throw new UnsupportedOperationException("Unsupported Node type: " + type);
        }
    }
}
