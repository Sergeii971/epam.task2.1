package com.verbovskiy.task9.reader;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PyramidDataReader {
    private static Logger logger = LogManager.getLogger(PyramidDataReader.class);

    public List<String> readFileData(String fileName) {
        List<String> lines = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            lines = stream.collect(Collectors.toList());
            logger.log(Level.INFO,"file was successfully read!");
        } catch (IOException e) {
            logger.log(Level.FATAL,"Error while reading file!", e);
        }
        return lines;
    }
}
