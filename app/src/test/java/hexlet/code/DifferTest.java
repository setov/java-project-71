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
        var file1Path = getFixturePath("flatFile1.json");
        var file2Path = getFixturePath("flatFile2.json");
        var actual = generate(file1Path.toString(), file2Path.toString());
        assertEquals(expected, actual);
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