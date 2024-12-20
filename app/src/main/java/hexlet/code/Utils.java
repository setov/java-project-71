package hexlet.code;

import java.util.Collections;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

public class Utils {

    private static Map<String, Object> parse(String content, String type) throws Exception {
        ObjectMapper mapper;

        switch (type) {
            case "json":
                mapper = new ObjectMapper();
                break;
            case "yaml":
            case "yml":
                mapper = new ObjectMapper(new YAMLFactory());
                break;
            default:
                throw new UnsupportedOperationException("Unsupported file type: " + type);
        }
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }


    private static String readFile(String filepath) {
        try {
            var path = Paths.get(filepath).toAbsolutePath().normalize();
            return Files.readString(path).trim();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filepath, e);
        }
    }

    private static Map<String, Object> loadData(String filepath) throws Exception {
        var content = readFile(filepath);
        var type = FilenameUtils.getExtension(filepath);
        return parse(content, type);
    }

    public static Map<String, Object> getData(String filepath) {
        try {
            return loadData(filepath);
        } catch (Exception e) {
            return Collections.emptyMap();
        }
    }
}

