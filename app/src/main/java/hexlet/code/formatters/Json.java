package hexlet.code.formatters;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hexlet.code.model.Node;

public class Json {
    private static String json(List<Node> nodes) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(nodes);
    }

    public static String convertToJson(List<Node> ast) {
        try {
            return json(ast);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON: " + e.getMessage(), e);
        }
    }
}
