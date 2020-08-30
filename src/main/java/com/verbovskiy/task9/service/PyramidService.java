package com.verbovskiy.task9.service;

import com.verbovskiy.task9.entity.Dot;
import com.verbovskiy.task9.entity.TriangularPyramid;
import com.verbovskiy.task9.exception.TaskException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PyramidService {
    private static Logger logger = LogManager.getLogger(PyramidService.class);

    public double calculateVolume(TriangularPyramid pyramid) throws TaskException {
        if (pyramid == null) {
            throw new TaskException("incorrect data");
        }
        Dot firstFoundationTop = pyramid.getFirstFoundationTop();
        Dot secondFoundationTop = pyramid.getSecondFoundationTop();
        Dot thirdFoundationTop = pyramid.getThirdFoundationTop();
        Dot mainTop = pyramid.getMainTop();
        double foundationArea = calculateTriangleArea(firstFoundationTop, secondFoundationTop, thirdFoundationTop);
        logger.log(Level.INFO, "foundation area = " + foundationArea);
        double height = mainTop.getZCoordinate() - firstFoundationTop.getZCoordinate();
        logger.log(Level.INFO, "height = " + height);
        return ((double)1 / 3 * foundationArea * height);
    }

    public double calculateLateralSurfaceArea(TriangularPyramid pyramid) throws TaskException {
        if (pyramid == null) {
            throw new TaskException("incorrect data");
        }
        Dot firstFoundationTop = pyramid.getFirstFoundationTop();
        Dot secondFoundationTop = pyramid.getSecondFoundationTop();
        Dot thirdFoundationTop = pyramid.getThirdFoundationTop();
        Dot mainTop = pyramid.getMainTop();
        double edgeArea;
        double totalArea = 0.0;
        edgeArea = calculateTriangleArea(firstFoundationTop, secondFoundationTop, thirdFoundationTop);
        logger.log(Level.INFO, "area of first edge = " + edgeArea);
        totalArea += edgeArea;
        edgeArea = calculateTriangleArea(firstFoundationTop, secondFoundationTop, mainTop);
        logger.log(Level.INFO, "area of second edge = " + edgeArea);
        totalArea += edgeArea;
        edgeArea = calculateTriangleArea(firstFoundationTop, thirdFoundationTop, mainTop);
        logger.log(Level.INFO, "area of third edge = " + edgeArea);
        totalArea += edgeArea;
        edgeArea = calculateTriangleArea(secondFoundationTop, thirdFoundationTop, mainTop);
        logger.log(Level.INFO, "area of fourth edge = " + edgeArea);
        totalArea += edgeArea;
        return totalArea;

    }

    public boolean isPyramidFoundationLieInCoordinatePlane(TriangularPyramid pyramid) throws TaskException {
        if (pyramid == null) {
            throw new TaskException("incorrect data");
        }
        Dot firstFoundationTop = pyramid.getFirstFoundationTop();
        Dot secondFoundationTop = pyramid.getSecondFoundationTop();
        Dot thirdFoundationTop = pyramid.getThirdFoundationTop();
        return (((firstFoundationTop.getZCoordinate() == secondFoundationTop.getZCoordinate())
                && (firstFoundationTop.getZCoordinate() == thirdFoundationTop.getZCoordinate()))
                || ((firstFoundationTop.getXCoordinate() == secondFoundationTop.getXCoordinate())
                && (firstFoundationTop.getXCoordinate() == thirdFoundationTop.getXCoordinate()))
                || ((firstFoundationTop.getYCoordinate() == secondFoundationTop.getYCoordinate())
                && (firstFoundationTop.getYCoordinate() == thirdFoundationTop.getYCoordinate())));
    }

    public double calculatePyramidPartDissectedByPlaneVolumeRatio(TriangularPyramid pyramid,
                                                                  Dot firstDotIntersection,
                                                                  Dot secondDotIntersection,
                                                                  Dot thirdDotIntersection) throws TaskException {
        if ((pyramid == null) || (firstDotIntersection == null) || (secondDotIntersection == null)
                || (thirdDotIntersection == null)) {
            throw new TaskException("incorrect data");
        }
        Dot mainTop = pyramid.getMainTop();
        TriangularPyramid pyramidFirstPart = new TriangularPyramid(firstDotIntersection, secondDotIntersection,
                thirdDotIntersection, mainTop);
        double pyramidVolume = calculateVolume(pyramid);
        logger.log(Level.INFO, "pyramid volume = " + pyramidVolume);
        double pyramidFirstPartVolume = calculateVolume(pyramidFirstPart);
        logger.log(Level.INFO, "pyramid first part volume = " + pyramidFirstPartVolume);
        double pyramidSecondPartVolume = pyramidVolume - pyramidFirstPartVolume;
        logger.log(Level.INFO, "pyramid second part volume = " + pyramidSecondPartVolume);
        return pyramidFirstPartVolume / pyramidSecondPartVolume;
    }

    private double calculateSideLength(Dot segmentStart, Dot segmentEnd) {
        return Math.sqrt(Math.pow(segmentStart.getXCoordinate() - segmentEnd.getXCoordinate(), 2)
        + Math.pow(segmentStart.getYCoordinate() - segmentEnd.getYCoordinate(), 2)
        + Math.pow(segmentStart.getZCoordinate() - segmentEnd.getZCoordinate(), 2));
    }

    private double calculatePerimeter(double ... sides) {
        double perimeter = 0;
        for (double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }

    private double calculateTriangleArea(Dot firstTop, Dot secondTop, Dot thirdTop) {
        double firstSide = calculateSideLength(firstTop, secondTop);
        logger.log(Level.INFO, "length of first side = " + firstSide);
        double secondSide = calculateSideLength(firstTop, thirdTop);
        logger.log(Level.INFO, "length of second side = " + secondSide);
        double thirdSide = calculateSideLength(secondTop, thirdTop);
        logger.log(Level.INFO, "length of third side = " + thirdSide);
        double perimeter = calculatePerimeter(firstSide, secondSide, thirdSide);
        logger.log(Level.INFO, "perimeter = " + perimeter);
        double halfPerimeter = perimeter / 2;

        return Math.sqrt((halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide)
                * halfPerimeter);
    }
}
