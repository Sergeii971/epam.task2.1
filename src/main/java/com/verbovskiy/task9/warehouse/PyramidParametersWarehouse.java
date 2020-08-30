package com.verbovskiy.task9.warehouse;

import com.verbovskiy.task9.entity.PyramidParameters;
import com.verbovskiy.task9.exception.TaskException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class PyramidParametersWarehouse {
    private static PyramidParametersWarehouse instance;
    private final Map<Integer, PyramidParameters> parametersMap;

    private static Logger logger = LogManager.getLogger(PyramidParametersWarehouse.class);

    private PyramidParametersWarehouse() {
        parametersMap = new HashMap<>();
    }

    public static PyramidParametersWarehouse getInstance() {
        if (instance == null) {
            instance = new PyramidParametersWarehouse();
        }
        return instance;
    }

    public void add(int id, PyramidParameters parameters) throws TaskException {
        if (parameters == null) {
            throw new TaskException();
        }
        parametersMap.put(id, parameters);
    }

    public PyramidParameters getPyramidParameters(int id) {
        PyramidParameters parameters = null;
        if (parametersMap.containsKey(id)){
            parameters = parametersMap.get(id);
        } else{
            logger.log(Level.ERROR, "incorrect data");
        }
        return parameters;
    }
}
