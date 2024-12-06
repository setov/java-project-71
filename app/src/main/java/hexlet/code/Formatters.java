package hexlet.code;

import java.util.List;

import hexlet.code.model.Node;
import static hexlet.code.formatters.Stylish.stylish;
import static hexlet.code.formatters.Plain.plain;
import static hexlet.code.formatters.Json.convertToJson;

public class Formatters {
    public static String render(List<Node> ast, String format) {
        switch (format) {
            case "stylish":
                return stylish(ast);
            case "plain":
                return plain(ast);
            case "json":
                return convertToJson(ast);
            default:
                throw new UnsupportedOperationException("Unsupported file format: " + format);
        }
    }
}
