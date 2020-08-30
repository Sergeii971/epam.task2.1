package com.verbovskiy.task9.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PyramidParser {
    private final String DELIMITER = " ";

    public List<Double> parsePyramidData(String line) {
        List<Double> pyramidData = new ArrayList<>();
            List<String> coordinatesStringFormat = Arrays.asList(line.split(DELIMITER));
            for (String coordinateStringFormat : coordinatesStringFormat) {
                double coordinate = Double.parseDouble(coordinateStringFormat);
                pyramidData.add(coordinate);
            }
        return pyramidData;
    }
}
