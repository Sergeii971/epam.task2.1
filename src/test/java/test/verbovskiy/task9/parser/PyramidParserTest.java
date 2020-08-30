package test.verbovskiy.task9.parser;

import com.verbovskiy.task9.parser.PyramidParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class PyramidParserTest {
    PyramidParser pyramidParser;

    @BeforeClass
    public void setUp() {
        pyramidParser = new PyramidParser();
    }

    @Test
    public void parsePyramidDataPositiveTest() {
        String line = "1.0 2.0 3.0";
        List<Double> actual = pyramidParser.parsePyramidData(line);
        List<Double> expected = new ArrayList<>();
        expected.add(1.0);
        expected.add(2.0);
        expected.add(3.0);
        assertEquals(actual, expected);
    }

    @Test
    public void parsePyramidDataNegativeTest() {
        String line = "1.0 2.0 3.0";
        List<Double> actual = pyramidParser.parsePyramidData(line);
        List<Double> expected = new ArrayList<>();
        expected.add(1.0);
        expected.add(3.0);
        expected.add(3.0);
        assertNotEquals(actual, expected);
    }
}