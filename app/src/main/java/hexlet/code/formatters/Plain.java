package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import hexlet.code.model.Node;

public class Plain {
    public static String plain(List<Node> nodes) {
        return nodes.stream()
                .map(Plain::formatNodePlain)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining("\n"));

    }

    private static String formatNodePlain(Node node) {
        var name = node.getName();
        var type = node.getType();
        var valueBefore = getFormattedValue(node.getValueBefore());
        var valueAfter = getFormattedValue(node.getValueAfter());

        return switch (type) {
            case "removed" -> String.format("Property '%s' was removed", name);
            case "unchanged" -> "";
            case "updated" -> String.format("Property '%s' was updated. From %s to %s", name, valueBefore, valueAfter);
            case "added" -> String.format("Property '%s' was added with value: %s", name, valueAfter);
            default -> throw new UnsupportedOperationException("Unsupported Node type: " + type);
        };
    }

    private static Object getFormattedValue(Object value) {
        return Optional.ofNullable(value)
            .map(v -> {
                if (v instanceof List || v instanceof Map) {
                    return "[complex value]";
                } else if (v instanceof String) {
                    return String.format("'%s'", v);
                } else {
                    return v;
                }
            })
            .orElse(null);
    }

}
