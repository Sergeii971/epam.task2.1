package com.verbovskiy.task9.observer.impl;

import com.verbovskiy.task9.entity.PyramidParameters;
import com.verbovskiy.task9.entity.TriangularPyramid;
import com.verbovskiy.task9.exception.TaskException;
import com.verbovskiy.task9.observer.Observer;
import com.verbovskiy.task9.observer.PyramidEvent;
import com.verbovskiy.task9.service.PyramidService;
import com.verbovskiy.task9.warehouse.PyramidParametersWarehouse;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PyramidObserverImpl implements Observer<PyramidEvent> {
    private static Logger logger = LogManager.getLogger(PyramidObserverImpl.class);

    @Override
    public void actionPerformed(PyramidEvent eventObject) {
        try {
            TriangularPyramid eventPyramid = eventObject.getSource();
            PyramidService service = new PyramidService();
            PyramidParametersWarehouse warehouse = PyramidParametersWarehouse.getInstance();
            double volume = service.calculateVolume(eventPyramid);
            double lateralSurfaceArea = service.calculateLateralSurfaceArea(eventPyramid);
            PyramidParameters parameters = new PyramidParameters(volume, lateralSurfaceArea);

            warehouse.add(eventPyramid.getId(), parameters);
        } catch (TaskException e) {
            logger.log(Level.ERROR, "incorrect data", e);
        }
    }
}
