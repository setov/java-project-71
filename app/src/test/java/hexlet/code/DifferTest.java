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

    private static String expectedStylish;
    private static String expectedPlain;

    @BeforeAll
    static void beforeAll() throws Exception {
        expectedStylish = readFixture("expectedStylish.txt");
        expectedPlain = readFixture("expectedPlain.txt");
    }

    @Test
    public void testGenerate() throws Exception {
        String formatStylish = "stylish";
        var file1PathJson = getFixturePath("file1.json");
        var file2PathJson = getFixturePath("file2.json");
        var actualJson = generate(file1PathJson.toString(), file2PathJson.toString(), formatStylish);
        assertEquals(expectedStylish, actualJson);

        var file1PathYaml = getFixturePath("file1.yaml");
        var file2PathYaml = getFixturePath("file2.yaml");
        var actualYaml = generate(file1PathYaml.toString(), file2PathYaml.toString(), formatStylish);
        assertEquals(expectedStylish, actualYaml);

        var file1PathYml = getFixturePath("file1.yml");
        var file2PathYml = getFixturePath("file2.yml");
        var actualYml = generate(file1PathYml.toString(), file2PathYml.toString(), formatStylish);
        assertEquals(expectedStylish, actualYml);

        String formatPlain = "plain";
        var actualJsonPlain = generate(file1PathJson.toString(), file2PathJson.toString(), formatPlain);
        assertEquals(expectedPlain, actualJsonPlain);

        var actualYamlPlain = generate(file1PathYaml.toString(), file2PathYaml.toString(), formatPlain);
        assertEquals(expectedPlain, actualYamlPlain);

        var actualYmlPlain = generate(file1PathYml.toString(), file2PathYml.toString(), formatPlain);
        assertEquals(expectedPlain, actualYmlPlain);

        var actualJsonDefault = generate(file1PathJson.toString(), file2PathJson.toString());
        assertEquals(expectedStylish, actualJsonDefault);
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
