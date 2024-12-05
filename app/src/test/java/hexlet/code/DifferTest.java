package hexlet.code;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import static hexlet.code.Differ.generate;

class DifferTest {

    private static String expected;

    @BeforeAll
    static void beforeAll() throws Exception {
        expected = readFixture("expected.txt");
    }

    @Test
    public void testGenerate() throws Exception {
        String format = "stylish";
        var file1PathJson = getFixturePath("file1.json");
        var file2PathJson = getFixturePath("file2.json");
        var actualJson = generate(file1PathJson.toString(), file2PathJson.toString(), format);
        assertEquals(expected, actualJson);

        var file1PathYaml = getFixturePath("file1.yaml");
        var file2PathYaml = getFixturePath("file2.yaml");
        var actualYaml = generate(file1PathYaml.toString(), file2PathYaml.toString(), format);
        assertEquals(expected, actualYaml);

        var file1PathYml = getFixturePath("file1.yml");
        var file2PathYml = getFixturePath("file2.yml");
        var actualYml = generate(file1PathYml.toString(), file2PathYml.toString(), format);
        assertEquals(expected, actualYml);
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
            .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }
}
