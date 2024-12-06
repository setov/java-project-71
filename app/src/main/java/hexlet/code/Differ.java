package hexlet.code;

import java.util.List;

import hexlet.code.model.Node;
import static hexlet.code.Formatters.render;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) {
        var data1 = Utils.getData(filePath1);
        var data2 = Utils.getData(filePath2);
        List<Node> ast = AstData.genAst(data1, data2);
        return render(ast, format);
    }

    public static String generate(String filePath1, String filePath2) {
        return generate(filePath1, filePath2, "stylish");
    }
}
