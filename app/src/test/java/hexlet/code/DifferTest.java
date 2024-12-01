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
        expected = readFixture("out.txt");
    }

    @Test
    public void testGenerate() throws Exception {
        var file1PathJson = getFixturePath("flatFile1.json");
        var file2PathJson = getFixturePath("flatFile2.json");
        var actualJson = generate(file1PathJson.toString(), file2PathJson.toString());
        assertEquals(expected, actualJson);

        var file1PathYaml = getFixturePath("flatFile1.yaml");
        var file2PathYaml = getFixturePath("flatFile2.yaml");
        var actualYaml = generate(file1PathYaml.toString(), file2PathYaml.toString());
        assertEquals(expected, actualYaml);
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
