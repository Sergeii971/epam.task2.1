package test.verbovskiy.task9.validator;

import com.verbovskiy.task9.entity.Dot;
import com.verbovskiy.task9.entity.TriangularPyramid;
import com.verbovskiy.task9.exception.TaskException;
import com.verbovskiy.task9.validator.PyramidValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PyramidValidatorTest {
    PyramidValidator pyramidValidator;

    @BeforeClass
    public void setUp() {
        pyramidValidator = new PyramidValidator();
    }

    @Test
    public void isPyramidDataCorrectPositiveTest() {
        String data = "1.0 1.0 1.0 2.0 2.0 1.0 3.0 3.0 1.0 4.0 4.0 4.0";
        boolean actual = pyramidValidator.isPyramidDataCorrect(data);
        assertTrue(actual);
    }

    @Test
    public void isPyramidDataCorrectNegativeTest() {
        String data = "1.0 y 1.0 2.0 2.0 z 3.0 3.0 1.0 u 4.0 4.0";
        boolean actual = pyramidValidator.isPyramidDataCorrect(data);
        assertFalse(actual);
    }

    @Test
    public void isShapePyramidPositiveTest() throws TaskException {
        Dot firstFoundationTop = new Dot(0,0,0);
        Dot secondFoundationTop = new Dot(0,2,0);
        Dot thirdFoundationTop = new Dot(1,0,0);
        Dot mainTop = new Dot(0,0,3);
        TriangularPyramid pyramid = new TriangularPyramid(firstFoundationTop, secondFoundationTop,
                thirdFoundationTop, mainTop);
        boolean actual = pyramidValidator.isShapePyramid(pyramid);
        assertTrue(actual);
    }

    @Test
    public void isShapePyramidNegativeTest() throws TaskException {
        Dot firstFoundationTop = new Dot(0,0,1);
        Dot secondFoundationTop = new Dot(0,2,2);
        Dot thirdFoundationTop = new Dot(1,0,3);
        Dot mainTop = new Dot(0,0,3);
        TriangularPyramid pyramid = new TriangularPyramid(firstFoundationTop, secondFoundationTop,
                thirdFoundationTop, mainTop);
        boolean actual = pyramidValidator.isShapePyramid(pyramid);
        assertFalse(actual);
    }
}