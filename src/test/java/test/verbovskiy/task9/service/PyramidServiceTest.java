package test.verbovskiy.task9.service;

import com.verbovskiy.task9.entity.Dot;
import com.verbovskiy.task9.entity.TriangularPyramid;
import com.verbovskiy.task9.exception.TaskException;
import com.verbovskiy.task9.service.PyramidService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PyramidServiceTest {
    PyramidService pyramidService;

    @BeforeClass
    public void setUp() {
        pyramidService = new PyramidService();
    }

    @Test
    public void calculateVolumePositiveTest() throws TaskException {
        Dot firstFoundationTop = new Dot(0,0,0);
        Dot secondFoundationTop = new Dot(0,2,0);
        Dot thirdFoundationTop = new Dot(1,0,0);
        Dot mainTop = new Dot(0,0,3);
        TriangularPyramid pyramid = new TriangularPyramid(firstFoundationTop, secondFoundationTop,
                thirdFoundationTop, mainTop);
        double actual = pyramidService.calculateVolume(pyramid);
        double expected = 1;
        System.out.println("\n");
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void calculateVolumeNegativeTest() throws TaskException {
        Dot firstFoundationTop = new Dot(0,0,0);
        Dot secondFoundationTop = new Dot(0,2,0);
        Dot thirdFoundationTop = new Dot(1,0,0);
        Dot mainTop = new Dot(0,0,3);
        TriangularPyramid pyramid = new TriangularPyramid(firstFoundationTop, secondFoundationTop,
                thirdFoundationTop, mainTop);
        double actual = pyramidService.calculateVolume(pyramid);
        double expected = 2;
        assertNotEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = TaskException.class)
    public void calculateVolumeExceptionTest() throws TaskException {
        pyramidService.calculateVolume(null);
    }

    @Test
    public void calculateLateralSurfaceAreaPositiveTest() throws TaskException {
        Dot firstFoundationTop = new Dot(0,0,0);
        Dot secondFoundationTop = new Dot(0,2,0);
        Dot thirdFoundationTop = new Dot(1,0,0);
        Dot mainTop = new Dot(0,0,3);
        TriangularPyramid pyramid = new TriangularPyramid(firstFoundationTop, secondFoundationTop,
                thirdFoundationTop, mainTop);
        double actual = pyramidService.calculateLateralSurfaceArea(pyramid);
        double expected = 9;
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void calculateLateralSurfaceAreaNegativeTest() throws TaskException {
        Dot firstFoundationTop = new Dot(0,0,0);
        Dot secondFoundationTop = new Dot(0,2,0);
        Dot thirdFoundationTop = new Dot(1,0,0);
        Dot mainTop = new Dot(0,0,3);
        TriangularPyramid pyramid = new TriangularPyramid(firstFoundationTop, secondFoundationTop,
                thirdFoundationTop, mainTop);
        double actual = pyramidService.calculateLateralSurfaceArea(pyramid);
        double expected = 10;
        assertNotEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = TaskException.class)
    public void calculateLateralSurfaceAreaExceptionTest() throws TaskException {
        pyramidService.calculateLateralSurfaceArea(null);
    }

    @Test
    public void isPyramidFoundationLieInCoordinatePlanePositiveTest() throws TaskException {
        Dot firstFoundationTop = new Dot(0,0,0);
        Dot secondFoundationTop = new Dot(0,2,0);
        Dot thirdFoundationTop = new Dot(1,0,0);
        Dot mainTop = new Dot(0,0,3);
        TriangularPyramid pyramid = new TriangularPyramid(firstFoundationTop, secondFoundationTop,
                thirdFoundationTop, mainTop);
        boolean actual = pyramidService.isPyramidFoundationLieInCoordinatePlane(pyramid);
        assertTrue(actual);
    }

    @Test
    public void isPyramidFoundationLieInCoordinatePlaneNegativeTest() throws TaskException {
        Dot firstFoundationTop = new Dot(0,0,1 );
        Dot secondFoundationTop = new Dot(0,2,2);
        Dot thirdFoundationTop = new Dot(1,0,3);
        Dot mainTop = new Dot(0,0,3);
        TriangularPyramid pyramid = new TriangularPyramid(firstFoundationTop, secondFoundationTop,
                thirdFoundationTop, mainTop);
        boolean actual = pyramidService.isPyramidFoundationLieInCoordinatePlane(pyramid);
        assertFalse(actual);
    }

    @Test(expectedExceptions = TaskException.class)
    public void isPyramidFoundationLieInCoordinatePlaneExceptionTest() throws TaskException {
        pyramidService.isPyramidFoundationLieInCoordinatePlane(null);
    }

    @Test
    public void calculatePyramidPartDissectedByPlaneVolumeRatioPositiveTest() throws TaskException {
        Dot firstFoundationTop = new Dot(0,0,0);
        Dot secondFoundationTop = new Dot(0,2,0);
        Dot thirdFoundationTop = new Dot(2,0,0);
        Dot mainTop = new Dot(0,0,3);
        TriangularPyramid pyramid = new TriangularPyramid(firstFoundationTop, secondFoundationTop,
                thirdFoundationTop, mainTop);
        Dot firstDotIntersection = new Dot(0,0,2);
        Dot secondDotIntersection = new Dot(0,0.66,2);
        Dot thirdDotIntersection = new Dot(0.66,0,2);
        double actual = pyramidService.calculatePyramidPartDissectedByPlaneVolumeRatio(pyramid,
                firstDotIntersection, secondDotIntersection, thirdDotIntersection);
        double expected = 0.038;
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void calculatePyramidPartDissectedByPlaneVolumeRatioNegativeTest() throws TaskException {
        Dot firstFoundationTop = new Dot(0,0,0);
        Dot secondFoundationTop = new Dot(0,2,0);
        Dot thirdFoundationTop = new Dot(2,0,0);
        Dot mainTop = new Dot(0,0,3);
        TriangularPyramid pyramid = new TriangularPyramid(firstFoundationTop, secondFoundationTop,
                thirdFoundationTop, mainTop);
        Dot firstDotIntersection = new Dot(0,0,2);
        Dot secondDotIntersection = new Dot(0,0.66,2);
        Dot thirdDotIntersection = new Dot(0.66,0,2);
        double actual = pyramidService.calculatePyramidPartDissectedByPlaneVolumeRatio(pyramid,
                firstDotIntersection, secondDotIntersection, thirdDotIntersection);
        double expected = 1;
        assertNotEquals(actual, expected, 0.001);
    }

    @Test(expectedExceptions = TaskException.class)
    public void calculatePyramidPartDissectedByPlaneVolumeRatioExceptionTest() throws TaskException {
        pyramidService.calculatePyramidPartDissectedByPlaneVolumeRatio(null,null,
                null,null);
    }
}