package hexlet.code;

import java.util.List;
import java.util.stream.Collectors;

import hexlet.code.model.Node;

public class Differ {
	private static String stringify(List<Node> nodes) {
        var list = nodes.stream()
                .map(Differ::formatNode)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining("\n"));
        return "{\n" + list + "\n}";
    }

    private static String formatNode(Node node) {
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
	public static String generate(String filePath1, String filePath2) {
		var data1 = Utils.getData(filePath1);
		var data2 = Utils.getData(filePath2);

		List<Node> ast = AstData.genAst(data1, data2);
		return stringify(ast);
	}
}
