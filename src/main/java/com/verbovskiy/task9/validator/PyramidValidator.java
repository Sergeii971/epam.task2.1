package com.verbovskiy.task9.validator;

import com.verbovskiy.task9.entity.Dot;
import com.verbovskiy.task9.entity.TriangularPyramid;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PyramidValidator {
    private static final String REGEX_DOUBLE = "[+-]?\\d+\\.\\d+";
    private static final String SPACE = "\\s";
    private static final String REGEX_PYRAMID = "\\b" + REGEX_DOUBLE + SPACE + REGEX_DOUBLE + SPACE
            + REGEX_DOUBLE + SPACE + REGEX_DOUBLE + SPACE + REGEX_DOUBLE + SPACE + REGEX_DOUBLE + SPACE
            + REGEX_DOUBLE + SPACE + REGEX_DOUBLE + SPACE + REGEX_DOUBLE + SPACE
            + REGEX_DOUBLE + SPACE + REGEX_DOUBLE + SPACE + REGEX_DOUBLE + "\\b";

    private static Logger logger = LogManager.getLogger(PyramidValidator.class);

    public boolean isPyramidDataCorrect(String data) {
        return data.matches(REGEX_PYRAMID);
    }

    public boolean isShapePyramid(TriangularPyramid pyramid) {
        boolean result = true;

        if (pyramid == null) {
            result = false;
        } else {
        Dot firstFoundationTop = pyramid.getFirstFoundationTop();
        Dot secondFoundationTop = pyramid.getSecondFoundationTop();
        Dot thirdFoundationTop = pyramid.getThirdFoundationTop();

        if ((firstFoundationTop.getZCoordinate() != secondFoundationTop.getZCoordinate())
                || (firstFoundationTop.getZCoordinate() != thirdFoundationTop.getZCoordinate())) {
            result = false;
        }
        }
        return result;
    }
}
