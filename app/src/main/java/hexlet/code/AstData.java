package hexlet.code;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import hexlet.code.model.Node;

public class AstData {

	   // Union of two maps
	   private static Set<String> union(Map<String, ?> data1, Map<String, ?> data2) {
        return Stream.concat(data1.keySet().stream(), data2.keySet().stream())
                     .collect(Collectors.toSet());
    }

    // Generate the abstract syntax tree
    public static List<Node> genAst(Map<String, Object> firstData, Map<String, Object> secondData) {
        Set<String> unionKeys = union(firstData, secondData);

        return unionKeys.stream()
                .sorted()
                .map(key -> createNode(firstData, secondData, key))
                .collect(Collectors.toList());
    }

    private static Node createNode(Map<String, Object> firstData, Map<String, Object> secondData, String key) {

        var firstValue = firstData.get(key);
        var secondValue = secondData.get(key);

        if (!firstData.containsKey(key)) {
            return Node.makeNode("added", key, null, secondValue, Collections.emptyList());
        }

        if (!secondData.containsKey(key)) {
            return Node.makeNode("removed", key, firstValue, null, Collections.emptyList());
        }

        boolean isFirstValueMap = firstValue instanceof Map<?, ?>;
        boolean isSecondValueMap = secondValue instanceof Map<?, ?>;

        if (isFirstValueMap && isSecondValueMap) {
            var firstChild = (Map<?, ?>) firstValue;
            var secondChild = (Map<?, ?>) secondValue;
            return Node.makeNode("complex", key, null, null, genAst(castToMap(firstChild), castToMap(secondChild)));
        }

        if (Objects.equals(firstValue, secondValue)) {
            return Node.makeNode("unchanged", key, firstValue, firstValue, Collections.emptyList());
        }

        return Node.makeNode("updated", key, firstValue, secondValue, Collections.emptyList());
    }


    @SuppressWarnings("unchecked")
    private static Map<String, Object> castToMap(Map<?, ?> map) {
        return (Map<String, Object>) map;
    }

}