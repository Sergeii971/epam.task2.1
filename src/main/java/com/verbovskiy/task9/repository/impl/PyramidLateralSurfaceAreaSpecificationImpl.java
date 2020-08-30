package com.verbovskiy.task9.repository.impl;

import com.verbovskiy.task9.entity.PyramidParameters;
import com.verbovskiy.task9.entity.TriangularPyramid;
import com.verbovskiy.task9.repository.Specification;
import com.verbovskiy.task9.warehouse.PyramidParametersWarehouse;

public class PyramidLateralSurfaceAreaSpecificationImpl implements Specification {
    private final double min;
    private final double max;

    public PyramidLateralSurfaceAreaSpecificationImpl(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean test(TriangularPyramid pyramid) {
        PyramidParametersWarehouse warehouse = PyramidParametersWarehouse.getInstance();
        int id = pyramid.getId();
        PyramidParameters parameters = warehouse.getPyramidParameters(id);
        boolean result = false;
        if (parameters != null) {
            double lateralSurfaceArea = parameters.getLateralSurfaceArea();
            result = ((lateralSurfaceArea >= min) && (lateralSurfaceArea <= max));
        }
        return result;
    }
}
