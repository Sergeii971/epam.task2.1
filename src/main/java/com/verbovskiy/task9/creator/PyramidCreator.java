package com.verbovskiy.task9.creator;

import com.verbovskiy.task9.entity.Dot;
import com.verbovskiy.task9.entity.TriangularPyramid;
import com.verbovskiy.task9.exception.TaskException;
import com.verbovskiy.task9.parser.PyramidParser;
import com.verbovskiy.task9.reader.PyramidDataReader;
import com.verbovskiy.task9.validator.PyramidValidator;

import java.util.ArrayList;
import java.util.List;

public class PyramidCreator {
    public List<TriangularPyramid> createPyramidsFile(String filename) throws TaskException {
        List<TriangularPyramid> pyramids = new ArrayList<>();
        PyramidValidator validator = new PyramidValidator();
        PyramidDataReader reader = new PyramidDataReader();
        PyramidParser parser = new PyramidParser();
        List<String> lines = reader.readFileData(filename);

        for (String line : lines) {
            if (validator.isPyramidDataCorrect(line)) {
                List<Double> coordinates = parser.parsePyramidData(line);
                TriangularPyramid pyramid = createPyramid(coordinates);
                if (validator.isShapePyramid(pyramid)) {
                    pyramids.add(pyramid);
                }
            }
        }
            return pyramids;
    }

    private TriangularPyramid createPyramid(List<Double> coordinates) throws TaskException {
        Dot firstFoundationTop = new Dot(coordinates.get(0), coordinates.get(1), coordinates.get(2));
        Dot secondFoundationTop = new Dot(coordinates.get(3), coordinates.get(4), coordinates.get(5));
        Dot thirdFoundationTop = new Dot(coordinates.get(6), coordinates.get(7), coordinates.get(8));
        Dot mainTop = new Dot(coordinates.get(9), coordinates.get(10), coordinates.get(11));

        return new TriangularPyramid(firstFoundationTop, secondFoundationTop, thirdFoundationTop, mainTop);
    }
}
